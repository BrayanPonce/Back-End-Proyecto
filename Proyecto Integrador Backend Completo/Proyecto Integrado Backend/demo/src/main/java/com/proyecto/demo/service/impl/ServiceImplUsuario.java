package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.UsuarioDTO;
import com.proyecto.demo.Mapper.UsuarioMapper;
import com.proyecto.demo.entity.Persona;
import com.proyecto.demo.entity.Usuario;
import com.proyecto.demo.repository.RepositoryPersona;
import com.proyecto.demo.repository.RepositoryUsuario;
import com.proyecto.demo.service.ServiceUsuario;

import jakarta.transaction.Transactional;

@Transactional
@Service("usuarioServiceImpl")

public class ServiceImplUsuario implements ServiceUsuario {
    @Autowired
    @Qualifier("usuarioRepository")
    private RepositoryUsuario repositoryUsuario;

     @Autowired
    @Qualifier("personaRepository")
    private RepositoryPersona repositoryPersona;

    @Override
    public List<UsuarioDTO> getAll() {
      List<Usuario> estado = repositoryUsuario.findAll();  

        return estado.stream().map(UsuarioMapper::DatosAlDTO).collect(Collectors.toList());
   
    }

    @Override
    public UsuarioDTO getById(int id) {
         Usuario usuario = repositoryUsuario.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Usuario no encontrado"));
    return UsuarioMapper.DatosAlDTO(usuario);
     }

    @Transactional
    @Override
    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        Usuario usario = UsuarioMapper.DatosAlaEdentidad(usuarioDTO);
        Usuario savedUsuario = repositoryUsuario.save(usario);
        return UsuarioMapper.DatosAlDTO(savedUsuario);
    }

    @Override
    public UsuarioDTO update(int id, UsuarioDTO usuarioDTO) {
        Usuario existingUsuario = repositoryUsuario.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Usuario no encontrado"));

// Actualiza los campos del proyecto con los datos del DTO
        existingUsuario.setUSERNAME(usuarioDTO.getUSERNAME());
        existingUsuario.setPASSWORD(usuarioDTO.getPASSWORD());

         //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Proyecto
    if (usuarioDTO.getID_PERSONA() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (usuarioDTO.getID_PERSONA().getID_PERSONA() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Persona persona = repositoryPersona.findById(usuarioDTO.getID_PERSONA().getID_PERSONA())
                    .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
            existingUsuario.setPersonaR(persona);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingUsuario.setPersonaR(null);
        }
    }




        Usuario updatedUsario = repositoryUsuario.save(existingUsuario);
        return UsuarioMapper.DatosAlDTO(updatedUsario);    
   }

    @Override
    public void delete(int id) {
        Usuario usuario = repositoryUsuario.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Usuario no encontrado"));
    repositoryUsuario.delete(usuario);

  }

   
}
