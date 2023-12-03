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

import com.proyecto.demo.DTO.Grupo_UnivDTO;
import com.proyecto.demo.service.impl.ServiceImplGrupo_univ;


@RestController
@RequestMapping("/grupo_univ")

public class ControllerGrupo_Univ {
      @Autowired
    @Qualifier("grupo_univServiceImpl")
    private ServiceImplGrupo_univ serviceImplGrupo_Univ;


    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public List<Grupo_UnivDTO> getAll(){
        return serviceImplGrupo_Univ.getAll();
        
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public Grupo_UnivDTO get(@PathVariable int id){
        return serviceImplGrupo_Univ.getById(id);
    }


    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public Grupo_UnivDTO create(@RequestBody Grupo_UnivDTO grupo_univDTO ){


        return serviceImplGrupo_Univ.create(grupo_univDTO);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Grupo_UnivDTO editarEs(@PathVariable int id, @RequestBody Grupo_UnivDTO grupo_univDTO ){

        return serviceImplGrupo_Univ.update(id, grupo_univDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable int id){
        serviceImplGrupo_Univ.delete(id);
    }





    
}
