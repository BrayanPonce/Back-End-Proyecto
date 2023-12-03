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

import com.proyecto.demo.DTO.DocenteDTO;
import com.proyecto.demo.service.impl.ServiceImplDocente;


@RestController
@RequestMapping("/docente")

public class ControllerDocente {


       @Autowired
    @Qualifier("docenteServiceImpl")
    private ServiceImplDocente serviceImplDocente;


    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public List<DocenteDTO> getAll(){
        return serviceImplDocente.getAll();
        
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public DocenteDTO get(@PathVariable int id){
        return serviceImplDocente.getById(id);
    }


    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public DocenteDTO create(@RequestBody DocenteDTO docenteDTO ){


        return serviceImplDocente.create(docenteDTO);
    }

    @PutMapping("/editar/{id}")
     @PreAuthorize("hasRole('ADMIN')")
    public DocenteDTO editarEs(@PathVariable int id, @RequestBody DocenteDTO docenteDTO ){

        return serviceImplDocente.update(id, docenteDTO);
    }

    @DeleteMapping("/eliminar/{id}")
     @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable int id){
        serviceImplDocente.delete(id);
    }








    
}
