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

import com.proyecto.demo.DTO.Rol_ProyectoDTO;
import com.proyecto.demo.service.impl.ServiceImplRol_Proyecto;

@RestController
@RequestMapping("/rol_proyecto")

public class ControllerRol_Proyecto {

    
    @Autowired
    @Qualifier("rol_proyectoServiceImpl")
    private ServiceImplRol_Proyecto serviceImplRol_Proyecto;


    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public List<Rol_ProyectoDTO> getAll(){
        return serviceImplRol_Proyecto.getAll();
        
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public Rol_ProyectoDTO get(@PathVariable int id){
        return serviceImplRol_Proyecto.getById(id);
    }


    @PostMapping("/agregar")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Rol_ProyectoDTO create(@RequestBody Rol_ProyectoDTO rol_proyectoDTO ){


        return serviceImplRol_Proyecto.create(rol_proyectoDTO);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Rol_ProyectoDTO editarEs(@PathVariable int id, @RequestBody Rol_ProyectoDTO rol_proyectoDTO ){

        return serviceImplRol_Proyecto.update(id, rol_proyectoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable int id){
        serviceImplRol_Proyecto.delete(id);
    }






    
    
}
