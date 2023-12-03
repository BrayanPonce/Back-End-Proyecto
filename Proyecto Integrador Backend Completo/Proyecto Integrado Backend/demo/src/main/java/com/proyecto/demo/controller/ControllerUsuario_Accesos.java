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

import com.proyecto.demo.DTO.Usuario_AccesosDTO;
import com.proyecto.demo.service.impl.ServiceImplUsuario_Accesos;


@RestController
@RequestMapping("/usuario_accesos")

public class ControllerUsuario_Accesos {

    
    @Autowired
    @Qualifier("usuario_accesosServiceImpl")
    private ServiceImplUsuario_Accesos serviceImplPersona_Accesos;


    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Usuario_AccesosDTO> getAll(){
        return serviceImplPersona_Accesos.getAll();
        
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario_AccesosDTO get(@PathVariable int id){
        return serviceImplPersona_Accesos.getById(id);
    }


    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario_AccesosDTO create(@RequestBody Usuario_AccesosDTO usuario_accesosDTO ){


        return serviceImplPersona_Accesos.create(usuario_accesosDTO);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario_AccesosDTO editarEs(@PathVariable int id, @RequestBody Usuario_AccesosDTO usuario_accesosDTO ){

        return serviceImplPersona_Accesos.update(id, usuario_accesosDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable int id){
        serviceImplPersona_Accesos.delete(id);
    }




    
}
