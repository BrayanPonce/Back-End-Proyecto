package com.proyecto.demo.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.Rol_ProyectoDTO;
import com.proyecto.demo.Mapper.Rol_ProyectoMapper;
import com.proyecto.demo.entity.Proyecto;
import com.proyecto.demo.entity.Rol_Negocio;
import com.proyecto.demo.entity.Rol_Proyecto;
import com.proyecto.demo.repository.RepositoryProyecto;
import com.proyecto.demo.repository.RepositoryRol_Negocio;
import com.proyecto.demo.repository.RepositoryRol_Proyecto;
import com.proyecto.demo.service.ServiceRol_Proyecto;

import jakarta.transaction.Transactional;


@Transactional
@Service("rol_proyectoServiceImpl")

public class ServiceImplRol_Proyecto implements ServiceRol_Proyecto {
    @Autowired
    @Qualifier("rol_proyectoRepository")
    private RepositoryRol_Proyecto repositoryRol_Proyecto;

    @Autowired
    @Qualifier("proyectoRepository")
    private RepositoryProyecto repositoryProyecto;

    @Autowired
    @Qualifier("rol_negocioRepository")
    private RepositoryRol_Negocio repositoryRol_Negocio;

    @Override
    public List<Rol_ProyectoDTO> getAll() {
        List<Rol_Proyecto> estado = repositoryRol_Proyecto.findAll();  

        return estado.stream().map(Rol_ProyectoMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public Rol_ProyectoDTO getById(int id) {
         Rol_Proyecto Rol_proyecto = repositoryRol_Proyecto.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Rol_Proyecto no encontrado"));
    return Rol_ProyectoMapper.DatosAlDTO(Rol_proyecto);
     }

    @Override
    public Rol_ProyectoDTO create(Rol_ProyectoDTO rol_ProyectoDTO) {
        Rol_Proyecto rol_Proyecto = Rol_ProyectoMapper.DatosAlaEntidad(rol_ProyectoDTO);
        Rol_Proyecto savedRol_Proyecto = repositoryRol_Proyecto.save(rol_Proyecto);
        return Rol_ProyectoMapper.DatosAlDTO(savedRol_Proyecto);
    }

    @Override
    public Rol_ProyectoDTO update(int id, Rol_ProyectoDTO rol_ProyectoDTO) {
        Rol_Proyecto existingRol_Proyecto = repositoryRol_Proyecto.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Rol_Proyecto no encontrado"));

    // Actualiza los campos del proyecto con los datos del DTO
        existingRol_Proyecto.setHORA(rol_ProyectoDTO.getHORA());
        existingRol_Proyecto.setDESCRIPCION(rol_ProyectoDTO.getDESCRIPCION());

    //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Proyecto
    if (rol_ProyectoDTO.getID_PROYECTO() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (rol_ProyectoDTO.getID_PROYECTO().getID_PROYECTO() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Proyecto proyecto = repositoryProyecto.findById(rol_ProyectoDTO.getID_PROYECTO().getID_PROYECTO())
                    .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
            existingRol_Proyecto.setProyecto(proyecto);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingRol_Proyecto.setProyecto(null);
        }
    }
//----------------------------------------------------------------------------------- ROL_NEGOCIO

    if (rol_ProyectoDTO.getID_ROL_NEGOCIO() != null) {
        // Comprueba si el ROL_NEGOCIO tiene un ID_ROL_NEGOCIO válido
        if (rol_ProyectoDTO.getID_ROL_NEGOCIO().getID_ROL_NEGOCIO() != 0) {
            // Busca y asigna el objeto ROL_NEGOCIO existente basado en el ID proporcionado
            Rol_Negocio rol_negocio = repositoryRol_Negocio.findById(rol_ProyectoDTO.getID_ROL_NEGOCIO().getID_ROL_NEGOCIO())
                    .orElseThrow(() -> new PropertyNotFoundException("ROL_NEGOCIO no encontrado"));
            existingRol_Proyecto.setRol_negocio(rol_negocio);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Rol_Negocio
            existingRol_Proyecto.setRol_negocio(null);
        }
    }









        Rol_Proyecto updatedRol_Proyecto = repositoryRol_Proyecto.save(existingRol_Proyecto);
        return Rol_ProyectoMapper.DatosAlDTO(updatedRol_Proyecto);    
    }

    @Override
    public void delete(int id) {
        Rol_Proyecto rol_Proyecto = repositoryRol_Proyecto.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Rol_Proyecto no encontrado"));
    repositoryRol_Proyecto.delete(rol_Proyecto);

   }

    
    
}
