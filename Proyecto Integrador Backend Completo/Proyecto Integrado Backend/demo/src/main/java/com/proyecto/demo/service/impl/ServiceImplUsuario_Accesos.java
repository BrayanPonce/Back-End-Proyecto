package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.Usuario_AccesosDTO;
import com.proyecto.demo.Mapper.Usuario_AccesosMapper;
import com.proyecto.demo.entity.Acceso;
import com.proyecto.demo.entity.Usuario;
import com.proyecto.demo.entity.Usuario_Accesos;
import com.proyecto.demo.repository.RepositoryAcceso;
import com.proyecto.demo.repository.RepositoryUsuario;
import com.proyecto.demo.repository.RepositoryUsuario_Accesos;
import com.proyecto.demo.service.ServiceUsuario_Accesos;

import jakarta.transaction.Transactional;


@Transactional
@Service("usuario_accesosServiceImpl")
public class ServiceImplUsuario_Accesos implements ServiceUsuario_Accesos {

    @Autowired
    @Qualifier("usuario_accesosRepository")
    private RepositoryUsuario_Accesos repositoryUsuario_Accesos;

    @Autowired
    @Qualifier("accesoRepository")
    private RepositoryAcceso repositoryAcceso;

    @Autowired
    @Qualifier("usuarioRepository")
    private RepositoryUsuario repositoryUsuario;

    @Override
    public List<Usuario_AccesosDTO> getAll() {
         List<Usuario_Accesos> var = repositoryUsuario_Accesos.findAll();  

        return var.stream().map(Usuario_AccesosMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public Usuario_AccesosDTO getById(int id) {
        Usuario_Accesos var = repositoryUsuario_Accesos.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("usuario_Accesos no encontrado"));
    return Usuario_AccesosMapper.DatosAlDTO(var);
    }

    @Override
    public Usuario_AccesosDTO create(Usuario_AccesosDTO usuario_accesosDTO) {
        Usuario_Accesos var = Usuario_AccesosMapper.DatosAlaEdentidad(usuario_accesosDTO);
        Usuario_Accesos var2 = repositoryUsuario_Accesos.save(var);
        return Usuario_AccesosMapper.DatosAlDTO(var2);
   }

    @Override
    public Usuario_AccesosDTO update(int id, Usuario_AccesosDTO usuario_AccesosDTO) {
       Usuario_Accesos existingVar = repositoryUsuario_Accesos.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Usuario accesos no encontrado"));

    // Actualiza los campos del proyecto con los datos del DTO
           //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Proyecto
    if (usuario_AccesosDTO.getID_USUARIO() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (usuario_AccesosDTO.getID_USUARIO().getID_USUARIO() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Usuario Var2 = repositoryUsuario.findById(usuario_AccesosDTO.getID_USUARIO().getID_USUARIO())
                    .orElseThrow(() -> new PropertyNotFoundException("USUARIO no encontrado"));
            existingVar.setUsuario(Var2);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setUsuario(null);
        }
    } 

    //----------------------------------------------------------------------------------- Proyecto
    if (usuario_AccesosDTO.getID_ACCESOS() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (usuario_AccesosDTO.getID_ACCESOS().getID_ACCESOS() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Acceso Var2 = repositoryAcceso.findById(usuario_AccesosDTO.getID_ACCESOS().getID_ACCESOS())
                    .orElseThrow(() -> new PropertyNotFoundException("Acceso no encontrado"));
            existingVar.setAcceso(Var2);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setAcceso(null);
        }
    } 

        Usuario_Accesos updatedVar = repositoryUsuario_Accesos.save(existingVar);
        return Usuario_AccesosMapper.DatosAlDTO(updatedVar);    
   }

    @Override
    public void delete(int id) {
          Usuario_Accesos var = repositoryUsuario_Accesos.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("PA no encontrado"));
    repositoryUsuario_Accesos.delete(var);

   }

    
}
