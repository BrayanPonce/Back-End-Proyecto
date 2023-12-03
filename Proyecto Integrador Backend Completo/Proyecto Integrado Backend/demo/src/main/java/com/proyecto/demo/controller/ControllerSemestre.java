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

import com.proyecto.demo.DTO.SemestreDTO;
import com.proyecto.demo.service.impl.ServiceImplSemestre;

@RestController
@RequestMapping("/Semestre")

public class ControllerSemestre {

        @Autowired
        @Qualifier("semestreServiceImpl")
        private ServiceImplSemestre serviceSemestre;

     @GetMapping("/list")
     @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public List<SemestreDTO> getAllSemestre() {
        return serviceSemestre.getAllSemestre();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public SemestreDTO getSemestre(@PathVariable int id) {
        return serviceSemestre.getSemestreById(id);
    }

    @PostMapping("/agregar")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public SemestreDTO createSemestreDTO(@RequestBody SemestreDTO semestreDTO) {
        return serviceSemestre.createSemestre(semestreDTO);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public SemestreDTO updateSemestre(@PathVariable int id, @RequestBody SemestreDTO semestreDTO) {
        return serviceSemestre.updateSemestre(id, semestreDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProyecto(@PathVariable int id) {
        serviceSemestre.deleteSemestre(id);
        
    }
    
}
