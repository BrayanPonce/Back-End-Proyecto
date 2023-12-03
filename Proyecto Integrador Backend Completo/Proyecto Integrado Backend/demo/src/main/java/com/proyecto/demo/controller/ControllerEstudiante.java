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

import com.proyecto.demo.DTO.EstudianteDTO;
import com.proyecto.demo.service.impl.ServiceImplEstudiante;

@RestController
@RequestMapping("/estudiante")



public class ControllerEstudiante {

      @Autowired
    @Qualifier("estudianteServiceImpl")
    private ServiceImplEstudiante serviceImplEstudiante;


    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public List<EstudianteDTO> getAll(){
        return serviceImplEstudiante.getAll();
        
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public EstudianteDTO get(@PathVariable int id){
        return serviceImplEstudiante.getById(id);
    }


    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public EstudianteDTO create(@RequestBody EstudianteDTO estudianteDTO ){


        return serviceImplEstudiante.create(estudianteDTO);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public EstudianteDTO editarEs(@PathVariable int id, @RequestBody EstudianteDTO estudianteDTO ){

        return serviceImplEstudiante.update(id, estudianteDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable int id){
        serviceImplEstudiante.delete(id);
    }





    
}
