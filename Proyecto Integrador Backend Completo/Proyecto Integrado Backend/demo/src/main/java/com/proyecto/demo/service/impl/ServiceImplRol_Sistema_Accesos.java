package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.Rol_Sistema_AccesosDTO;
import com.proyecto.demo.Mapper.Rol_Sistema_AccesosMapper;
import com.proyecto.demo.entity.Acceso;
import com.proyecto.demo.entity.Rol_Sistema;
import com.proyecto.demo.entity.Rol_Sistema_Accesos;
import com.proyecto.demo.repository.RepositoryAcceso;
import com.proyecto.demo.repository.RepositoryRol_Sistema;
import com.proyecto.demo.repository.RepositoryRol_Sistema_Accesos;
import com.proyecto.demo.service.ServiceRol_Sistema_Accesos;

import jakarta.transaction.Transactional;


@Transactional
@Service("rol_sistema_accesosServiceImpl")

public class ServiceImplRol_Sistema_Accesos implements ServiceRol_Sistema_Accesos {
    @Autowired
    @Qualifier("rol_sistema_accesosRepository")
    private RepositoryRol_Sistema_Accesos  repositoryRol_Sistema_Accesos;

    @Autowired
    @Qualifier("rol_sistemaRepository")
    private RepositoryRol_Sistema  repositoryRol_Sistema;

    @Autowired
    @Qualifier("accesoRepository")
    private RepositoryAcceso  repositoryAcceso;







    @Override
    public List<Rol_Sistema_AccesosDTO> getAll() {
       List<Rol_Sistema_Accesos> estado = repositoryRol_Sistema_Accesos.findAll();  

        return estado.stream().map(Rol_Sistema_AccesosMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public Rol_Sistema_AccesosDTO getById(int id) {
          Rol_Sistema_Accesos rol_Sistema_Accesos = repositoryRol_Sistema_Accesos.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Rol_Sistema_Accesos no encontrado"));
    return Rol_Sistema_AccesosMapper.DatosAlDTO(rol_Sistema_Accesos);
    }

    @Override
    public Rol_Sistema_AccesosDTO create(Rol_Sistema_AccesosDTO rol_Sistema_AccesosDTO) {
        Rol_Sistema_Accesos rol_Sistema_Accesos = Rol_Sistema_AccesosMapper.DatosAlaEdentidad(rol_Sistema_AccesosDTO);
        Rol_Sistema_Accesos savedRol_Sistema_Accesos = repositoryRol_Sistema_Accesos.save(rol_Sistema_Accesos);
        return Rol_Sistema_AccesosMapper.DatosAlDTO(savedRol_Sistema_Accesos);
     }

    @Override
    public Rol_Sistema_AccesosDTO update(int id, Rol_Sistema_AccesosDTO rol_Sistema_AccesosDTO) {
        Rol_Sistema_Accesos existingVar = repositoryRol_Sistema_Accesos.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Rol_Sistema_Accesos no encontrado"));

    //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Proyecto
    if (rol_Sistema_AccesosDTO.getID_ROL_SISTEMA() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (rol_Sistema_AccesosDTO.getID_ROL_SISTEMA().getID_ROL_SISTEMA() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Rol_Sistema rol_sistema = repositoryRol_Sistema.findById(rol_Sistema_AccesosDTO.getID_ROL_SISTEMA().getID_ROL_SISTEMA())
                    .orElseThrow(() -> new PropertyNotFoundException("Rol_Sistema no encontrado"));
            existingVar.setRol_sistema(rol_sistema);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setRol_sistema(null);
        }
    }

      //----------------------------------------------------------------------------------- Proyecto
    if (rol_Sistema_AccesosDTO.getID_ACCESOS() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (rol_Sistema_AccesosDTO.getID_ACCESOS().getID_ACCESOS() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Acceso accesos = repositoryAcceso.findById(rol_Sistema_AccesosDTO.getID_ACCESOS().getID_ACCESOS())
                    .orElseThrow(() -> new PropertyNotFoundException("Accesos no encontrado"));
            existingVar.setAcceso(accesos);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setAcceso(null);
        }
    }













        Rol_Sistema_Accesos updatedRol_Sistema_Accesos = repositoryRol_Sistema_Accesos.save(existingVar);
        return Rol_Sistema_AccesosMapper.DatosAlDTO(updatedRol_Sistema_Accesos);    
    }

    @Override
    public void delete(int id) {
        Rol_Sistema_Accesos rol_Sistema_Accesos = repositoryRol_Sistema_Accesos.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estado no encontrado"));
    repositoryRol_Sistema_Accesos.delete(rol_Sistema_Accesos);

    }

}
