package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.DocenteDTO;
import com.proyecto.demo.Mapper.DocenteMapper;
import com.proyecto.demo.entity.Docente;
import com.proyecto.demo.entity.Persona;
import com.proyecto.demo.repository.RepositoryDocente;
import com.proyecto.demo.repository.RepositoryPersona;
import com.proyecto.demo.service.ServiceDocente;

import jakarta.transaction.Transactional;

@Transactional
@Service("docenteServiceImpl")

public class ServiceImplDocente implements ServiceDocente {


    @Autowired
    @Qualifier("docenteRepository")
    private RepositoryDocente repositoryDocente;

     @Autowired
    @Qualifier("personaRepository")
    private RepositoryPersona RepositoryPersona;

    @Override
    public List<DocenteDTO> getAll() {
          List<Docente> var = repositoryDocente.findAll();  

        return var.stream().map(DocenteMapper::DatosAlDTO).collect(Collectors.toList());
    }

    @Override
    public DocenteDTO getById(int id) {
         Docente var = repositoryDocente.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Docente no encontrado"));
    return DocenteMapper.DatosAlDTO(var);
    }

    @Override
    public DocenteDTO create(DocenteDTO docenteDTO) {
        Docente var = DocenteMapper.DatosAlaEdentidad(docenteDTO);
        Docente var2 = repositoryDocente.save(var);
        return DocenteMapper.DatosAlDTO(var2);
     }

    @Override
    public DocenteDTO update(int id, DocenteDTO docenteDTO) {
        Docente existingVar = repositoryDocente.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Docente no encontrado"));


   //----------------------------------------------------------------------------------- Proyecto
    if (docenteDTO.getID_PERSONA() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (docenteDTO.getID_PERSONA().getID_PERSONA() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Persona persona = RepositoryPersona.findById(docenteDTO.getID_PERSONA().getID_PERSONA())
                    .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
            existingVar.setPersona(persona);
        } else {
            // Maneja el caso en el que no se proporciona uno nuevo 
            existingVar.setPersona(null);
        }
    }












        Docente updatedVar = repositoryDocente.save(existingVar);
        return DocenteMapper.DatosAlDTO(updatedVar);    
    }

    @Override
    public void delete(int id) {
        Docente var = repositoryDocente.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Docente no encontrado"));
    repositoryDocente.delete(var);

    }

  
    
}
