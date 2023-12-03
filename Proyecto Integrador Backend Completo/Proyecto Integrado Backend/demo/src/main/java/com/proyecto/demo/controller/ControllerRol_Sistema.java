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

import com.proyecto.demo.DTO.Rol_SistemaDTO;
import com.proyecto.demo.service.impl.ServiceImplRol_Sistema;

@RestController
@RequestMapping("/rol_sistema")

public class ControllerRol_Sistema {

       @Autowired
    @Qualifier("rol_sistemaServiceImpl")
    private ServiceImplRol_Sistema serviceImplRol_Sistema;


    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Rol_SistemaDTO> getAll(){
        return serviceImplRol_Sistema.getAll();
        
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Rol_SistemaDTO get(@PathVariable int id){
        return serviceImplRol_Sistema.getById(id);
    }


    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public Rol_SistemaDTO create(@RequestBody Rol_SistemaDTO rol_sistemaDTO ){


        return serviceImplRol_Sistema.create(rol_sistemaDTO);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Rol_SistemaDTO editarEs(@PathVariable int id, @RequestBody Rol_SistemaDTO rol_sistemaDTO ){

        return serviceImplRol_Sistema.update(id, rol_sistemaDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable int id){
        serviceImplRol_Sistema.delete(id);
    }






    
}
