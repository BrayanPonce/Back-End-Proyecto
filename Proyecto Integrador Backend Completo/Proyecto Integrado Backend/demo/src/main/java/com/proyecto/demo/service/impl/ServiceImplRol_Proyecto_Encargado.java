package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.Rol_Proyecto_EncargadoDTO;
import com.proyecto.demo.Mapper.Rol_Proyecto_EncargadoMapper;
import com.proyecto.demo.entity.Encargado;
import com.proyecto.demo.entity.Rol_Proyecto;
import com.proyecto.demo.entity.Rol_Proyecto_Encargado;
import com.proyecto.demo.repository.RepositoryEncargado;
import com.proyecto.demo.repository.RepositoryRol_Proyecto;
import com.proyecto.demo.repository.RepositoryRol_Proyecto_Encargado;
import com.proyecto.demo.service.ServiceRol_Proyecto_Encargado;

import jakarta.transaction.Transactional;

@Transactional
    
@Service("rol_proyecto_encargadoServiceImpl")

public class ServiceImplRol_Proyecto_Encargado implements ServiceRol_Proyecto_Encargado {

    @Autowired
    @Qualifier("rol_proyectoRepository")
    private RepositoryRol_Proyecto repositoryRol_Proyecto;

    @Autowired
    @Qualifier("rol_proyecto_encargadoRepository")
    private RepositoryRol_Proyecto_Encargado repositoryRol_Proyecto_Encargado;

    @Autowired
    @Qualifier("encargadoRepository")
    private RepositoryEncargado repositoryEncargado;

    


    @Override
    public List<Rol_Proyecto_EncargadoDTO> getAll() {
      List<Rol_Proyecto_Encargado> estado = repositoryRol_Proyecto_Encargado.findAll();  

        return estado.stream().map(Rol_Proyecto_EncargadoMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public Rol_Proyecto_EncargadoDTO getById(int id) {
       Rol_Proyecto_Encargado rol_proyecto_encargado = repositoryRol_Proyecto_Encargado.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Rol_Proyecto_Encargado no encontrado"));
    return Rol_Proyecto_EncargadoMapper.DatosAlDTO(rol_proyecto_encargado);
    }

    @Override
    public Rol_Proyecto_EncargadoDTO create(Rol_Proyecto_EncargadoDTO rol_Proyecto_EncargadoDTO) {
        Rol_Proyecto_Encargado rol_Proyecto_Encargado = Rol_Proyecto_EncargadoMapper.DatosAlaEdentidad(rol_Proyecto_EncargadoDTO);
        Rol_Proyecto_Encargado savedRol_Proyecto_Encargado = repositoryRol_Proyecto_Encargado.save(rol_Proyecto_Encargado);
        return Rol_Proyecto_EncargadoMapper.DatosAlDTO(savedRol_Proyecto_Encargado);
   }

    @Override
    public Rol_Proyecto_EncargadoDTO update(int id, Rol_Proyecto_EncargadoDTO rol_Proyecto_EncargadoDTO) {
        Rol_Proyecto_Encargado existingVar = repositoryRol_Proyecto_Encargado.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("RPE no encontrado"));



            //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Proyecto
    if (rol_Proyecto_EncargadoDTO.getID_ENCARGADO() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (rol_Proyecto_EncargadoDTO.getID_ENCARGADO().getID_ENCARGADO() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Encargado Var2 = repositoryEncargado.findById(rol_Proyecto_EncargadoDTO.getID_ENCARGADO().getID_ENCARGADO())
                    .orElseThrow(() -> new PropertyNotFoundException("ENCARGADO no encontrado"));
            existingVar.setEncargado(Var2);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setEncargado(null);
        }
    }

     //----------------------------------------------------------------------------------- Proyecto
    if (rol_Proyecto_EncargadoDTO.getID_ROL_PROYECTO() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (rol_Proyecto_EncargadoDTO.getID_ROL_PROYECTO().getID_ROL_PROYECTO() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Rol_Proyecto Var2 = repositoryRol_Proyecto.findById(rol_Proyecto_EncargadoDTO.getID_ROL_PROYECTO().getID_ROL_PROYECTO())
                    .orElseThrow(() -> new PropertyNotFoundException("RP no encontrado"));
            existingVar.setRol_proyecto(Var2);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setRol_proyecto(null);
        }
    }



        Rol_Proyecto_Encargado updatedRol_Proyecto_Encargado = repositoryRol_Proyecto_Encargado.save(existingVar);
        return Rol_Proyecto_EncargadoMapper.DatosAlDTO(updatedRol_Proyecto_Encargado);    
    }

    @Override
    public void delete(int id) {
        Rol_Proyecto_Encargado rol_proyecto_Encargado = repositoryRol_Proyecto_Encargado.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("RPE no encontrado"));
    repositoryRol_Proyecto_Encargado.delete(rol_proyecto_Encargado);

   }

    
}
