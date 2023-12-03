package com.proyecto.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.demo.DTO.RecursoDTO;
import com.proyecto.demo.service.impl.ServiceImplRecurso;

@RestController
@RequestMapping("/Recurso")

public class ControllerRecurso {

    @Autowired
    @Qualifier("recursoServiceImpl")
    private ServiceImplRecurso  serviceImplRecurso;


      @GetMapping("/list")
      @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public List<RecursoDTO> getAllSemestre() {
        return serviceImplRecurso.getAll();
    }


    @GetMapping("/get/{id}")
     @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public RecursoDTO getSemestre(@PathVariable int id) {
        return serviceImplRecurso.getById(id);
    }


     @PostMapping("/agregar")
      @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public RecursoDTO createSemestreDTO(@RequestBody RecursoDTO recursoDTO) {
        return serviceImplRecurso.create(recursoDTO);
    }

     @PutMapping("/editar/{id}")
      @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public RecursoDTO updateRecurso(@PathVariable int id, @RequestBody RecursoDTO recursoDTO) {
        return serviceImplRecurso.update(id, recursoDTO);
    }

















    
}
