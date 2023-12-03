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

import com.proyecto.demo.DTO.Rol_Proyecto_EncargadoDTO;
import com.proyecto.demo.service.impl.ServiceImplRol_Proyecto_Encargado;

@RestController
@RequestMapping("/rol_proyecto_encargado")

public class ControllerRol_Proyecto_Encargado {
    
    @Autowired
    @Qualifier("rol_proyecto_encargadoServiceImpl")
    private ServiceImplRol_Proyecto_Encargado serviceImplRol_Proyecto_Encargado;


    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public List<Rol_Proyecto_EncargadoDTO> getAll(){
        return serviceImplRol_Proyecto_Encargado.getAll();
        
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public Rol_Proyecto_EncargadoDTO get(@PathVariable int id){
        return serviceImplRol_Proyecto_Encargado.getById(id);
    }


    @PostMapping("/agregar")
    @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public Rol_Proyecto_EncargadoDTO create(@RequestBody Rol_Proyecto_EncargadoDTO rol_proyecto_encargadoDTO ){


        return serviceImplRol_Proyecto_Encargado.create(rol_proyecto_encargadoDTO);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public Rol_Proyecto_EncargadoDTO editarEs(@PathVariable int id, @RequestBody Rol_Proyecto_EncargadoDTO rol_proyecto_encargadoDTO ){

        return serviceImplRol_Proyecto_Encargado.update(id, rol_proyecto_encargadoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable int id){
        serviceImplRol_Proyecto_Encargado.delete(id);
    }







    
}
