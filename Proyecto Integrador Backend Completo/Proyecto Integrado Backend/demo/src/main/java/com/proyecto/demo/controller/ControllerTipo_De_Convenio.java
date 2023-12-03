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

import com.proyecto.demo.DTO.Tipo_De_ConvenioDTO;
import com.proyecto.demo.service.ServiceTipo_De_Convenio;

@RestController
@RequestMapping("/convenio")


public class ControllerTipo_De_Convenio {
        @Autowired
        @Qualifier("tipo_de_convenioServiceImpl")
        private ServiceTipo_De_Convenio serviceTipo_De_Convenio;



    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR')")
    public List<Tipo_De_ConvenioDTO> getAllTipo_De_Convenio() {
        return serviceTipo_De_Convenio.getAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR')")
    public Tipo_De_ConvenioDTO getTipo_De_Convenio(@PathVariable int id) {
        return serviceTipo_De_Convenio.getById(id);
    }


      
    @PostMapping("/agregar")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR')")
    public Tipo_De_ConvenioDTO createTipo_De_Convenio(@RequestBody Tipo_De_ConvenioDTO tipo_De_ConvenioDTO) {
    return serviceTipo_De_Convenio.create(tipo_De_ConvenioDTO);
    }


    @PutMapping("/editar/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR')")
    public Tipo_De_ConvenioDTO updateTipo_De_Convenio(@PathVariable int id, @RequestBody Tipo_De_ConvenioDTO tipo_De_ConvenioDTO) {
        return serviceTipo_De_Convenio.update(id, tipo_De_ConvenioDTO);
    }


     @DeleteMapping("/eliminar/{id}")
     @PreAuthorize("hasRole('ADMIN')")
    public void deleteTipo_De_Convenio(@PathVariable int id) {
        serviceTipo_De_Convenio.delete(id);
        
    }


























    
}
