package com.proyecto.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.demo.DTO.PersonaDTO;
import com.proyecto.demo.service.impl.ServiceImplPersona;

@RestController
@RequestMapping("/persona")


public class ControllerPersona {
       @Autowired
    @Qualifier("personaServiceImpl")
    private ServiceImplPersona serviceImplPersona;


    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public List<PersonaDTO> getAll(){
        return serviceImplPersona.getAll();
        
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public PersonaDTO get(@PathVariable int id){
        return serviceImplPersona.getById(id);
    }


    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public PersonaDTO create(@RequestBody PersonaDTO personaDTO ){


        return serviceImplPersona.create(personaDTO);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public PersonaDTO editarEs(@PathVariable int id, @RequestBody PersonaDTO personaDTO ){

        return serviceImplPersona.update(id, personaDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable int id){
        serviceImplPersona.delete(id);
    }





    
}
