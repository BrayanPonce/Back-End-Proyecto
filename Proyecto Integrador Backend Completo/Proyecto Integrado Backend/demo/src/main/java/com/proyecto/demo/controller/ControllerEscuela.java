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

import com.proyecto.demo.DTO.EscuelaDTO;
import com.proyecto.demo.service.impl.ServiceImplEscuela;

@RestController
@RequestMapping("/Escuela")
public class ControllerEscuela {

 @Autowired
        @Qualifier("escuelaServiceImpl")
        private ServiceImplEscuela serviceImplEscuela;

    @GetMapping("/list")
     @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public List<EscuelaDTO> getAllEscuela() {
        return serviceImplEscuela.getAllEscuela();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public EscuelaDTO getEscuela(@PathVariable int id) {
        return serviceImplEscuela.getEscuelaById(id);
    }


      
    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public EscuelaDTO createEscuela(@RequestBody EscuelaDTO escuelaDTO) {
    return serviceImplEscuela.createEscuela(escuelaDTO);
    }


    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public EscuelaDTO updateEscuela(@PathVariable int id, @RequestBody EscuelaDTO escuelaDTO) {
        return serviceImplEscuela.updateEscuela(id, escuelaDTO);
    }


     @DeleteMapping("/eliminar/{id}")
     @PreAuthorize("hasRole('ADMIN')")
    public void deleteEscuela(@PathVariable int id) {
        serviceImplEscuela.deleteEscuela(id);
        
    }




























    
}
