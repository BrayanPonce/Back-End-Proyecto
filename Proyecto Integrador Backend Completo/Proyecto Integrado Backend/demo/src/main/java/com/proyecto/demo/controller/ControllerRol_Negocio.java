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

import com.proyecto.demo.DTO.Rol_NegocioDTO;
import com.proyecto.demo.service.impl.ServiceImplRol_Negocio;


@RestController
@RequestMapping("/rol_negocio")

public class ControllerRol_Negocio {
    
    @Autowired
    @Qualifier("rol_negocioServiceImpl")
    private ServiceImplRol_Negocio serviceImplRol_Negocio;


    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public List<Rol_NegocioDTO> getAll(){
        return serviceImplRol_Negocio.getAll();
        
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public Rol_NegocioDTO get(@PathVariable int id){
        return serviceImplRol_Negocio.getById(id);
    }


    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public Rol_NegocioDTO create(@RequestBody Rol_NegocioDTO rol_negocioDTO ){


        return serviceImplRol_Negocio.create(rol_negocioDTO);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Rol_NegocioDTO editarEs(@PathVariable int id, @RequestBody Rol_NegocioDTO rol_negocioDTO ){

        return serviceImplRol_Negocio.update(id, rol_negocioDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable int id){
        serviceImplRol_Negocio.delete(id);
    }






    
}
