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

import com.proyecto.demo.DTO.FacultadDTO;
import com.proyecto.demo.service.impl.ServiceImplFacultad;

@RestController
@RequestMapping("/facultad")

public class ControllerFacultad {
    
    @Autowired
    @Qualifier("facultadServiceImpl")
    private ServiceImplFacultad serviceImplFacultad;


    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public List<FacultadDTO> getAll(){
        return serviceImplFacultad.getAll();
        
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public FacultadDTO get(@PathVariable int id){
        return serviceImplFacultad.getById(id);
    }


    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public FacultadDTO create(@RequestBody FacultadDTO facultadDTO ){


        return serviceImplFacultad.create(facultadDTO);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public FacultadDTO editarEs(@PathVariable int id, @RequestBody FacultadDTO facultadDTO ){

        return serviceImplFacultad.update(id, facultadDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable int id){
        serviceImplFacultad.delete(id);
    }



    
}
