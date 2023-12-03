package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.PersonaDTO;
import com.proyecto.demo.Mapper.PersonaMapper;
import com.proyecto.demo.entity.Persona;
import com.proyecto.demo.entity.Rol_Sistema;
import com.proyecto.demo.repository.RepositoryPersona;
import com.proyecto.demo.repository.RepositoryRol_Sistema;
import com.proyecto.demo.service.ServicePersona;

import jakarta.transaction.Transactional;

@Transactional
@Service("personaServiceImpl")

public class ServiceImplPersona implements ServicePersona {

    @Autowired
    @Qualifier("personaRepository")
    private RepositoryPersona repositoryPersona;

    @Autowired
    @Qualifier("rol_sistemaRepository")
    private RepositoryRol_Sistema repositoryRol_Sistema;

    @Override
    public List<PersonaDTO> getAll() {
        List<Persona> var = repositoryPersona.findAll();  

        return var.stream().map(PersonaMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public PersonaDTO getById(int id) {
           Persona var = repositoryPersona.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Persona no encontrado"));
    return PersonaMapper.DatosAlDTO(var);
   }

    @Override
    public PersonaDTO create(PersonaDTO personaDTO) {
        Persona var = PersonaMapper.DatosAlaEdentidad(personaDTO);
        Persona var2 = repositoryPersona.save(var);
        return PersonaMapper.DatosAlDTO(var2);
    }

    @Override
    public PersonaDTO update(int id, PersonaDTO personaDTO) {
        Persona existingVar = repositoryPersona.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Persona no encontrado"));
    // Actualiza los campos del proyecto con los datos del DTO
        existingVar.setNOMBRE(personaDTO.getNOMBRE());
        existingVar.setDNI(personaDTO.getDNI());

         //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Proyecto
    if (personaDTO.getID_ROL_SISTEMA() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (personaDTO.getID_ROL_SISTEMA().getID_ROL_SISTEMA() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Rol_Sistema participante = repositoryRol_Sistema.findById(personaDTO.getID_ROL_SISTEMA().getID_ROL_SISTEMA())
                    .orElseThrow(() -> new PropertyNotFoundException("ROL_SISTEMA no encontrado"));
            existingVar.setRol_sistema(participante);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setRol_sistema(null);
        }
    }


        Persona updatedVar = repositoryPersona.save(existingVar);
        return PersonaMapper.DatosAlDTO(updatedVar);    
   }

    @Override
    public void delete(int id) {
        Persona var = repositoryPersona.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estado no encontrado"));
    repositoryPersona.delete(var);

  }
 
}
