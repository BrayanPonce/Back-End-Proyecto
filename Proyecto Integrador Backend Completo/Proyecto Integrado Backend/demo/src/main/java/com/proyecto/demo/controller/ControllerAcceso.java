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

import com.proyecto.demo.DTO.AccesoDTO;
import com.proyecto.demo.service.impl.ServiceimplAcceso;

@RestController
@RequestMapping("/acceso")



public class ControllerAcceso {

    @Autowired
    @Qualifier("accesoServiceImpl")
    private ServiceimplAcceso serviceImplAcceso;


    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public List<AccesoDTO> getAll(){
        return serviceImplAcceso.getAll();
        
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public AccesoDTO get(@PathVariable int id){
        return serviceImplAcceso.getById(id);
    }


    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public AccesoDTO create(@RequestBody AccesoDTO accesoDTO ){


        return serviceImplAcceso.create(accesoDTO);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AccesoDTO editarEs(@PathVariable int id, @RequestBody AccesoDTO accesoDTO ){

        return serviceImplAcceso.update(id, accesoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable int id){
        serviceImplAcceso.delete(id);
    }






    
}
