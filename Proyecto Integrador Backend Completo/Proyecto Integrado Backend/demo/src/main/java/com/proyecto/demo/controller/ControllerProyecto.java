package com.proyecto.demo.controller;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.demo.DTO.ProyectoDTO;
import com.proyecto.demo.service.impl.ServiceimplProyecto;


@RestController
@RequestMapping("/proyecto")


public class ControllerProyecto {

        @Autowired
        @Qualifier("proyectoServiceImpl")
        private ServiceimplProyecto proyectoService;

    
        @GetMapping("/list")
        @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public List<ProyectoDTO> getAllProyectos() {
        return proyectoService.getAllProyectos();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public ProyectoDTO getProyecto(@PathVariable int id) {
        return proyectoService.getProyectoById(id);
    }

    @PostMapping("/agregar")
      @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public ProyectoDTO createProyecto(@RequestBody ProyectoDTO proyectoDTO) {


        
        return proyectoService.createProyecto(proyectoDTO);
    }

    @PutMapping("/editar/{id}")
     @PreAuthorize("hasAnyRole('ADMIN','COORDINADOR')")
    public ProyectoDTO updateProyecto(@PathVariable int id, @RequestBody ProyectoDTO proyectoDTO) {
        return proyectoService.updateProyecto(id, proyectoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteProyecto(@PathVariable int id) {
        proyectoService.deleteProyecto(id);
        
    }

    @GetMapping("/nombre")
    @PreAuthorize("hasAnyRole('ADMIN','DIRECTOR','COORDINADOR','ESTUDIANTE','DOCENTE')")
    public ResponseEntity<List<ProyectoDTO>> buscarProyectosPorNombre(@RequestParam String nombre) {
    List<ProyectoDTO> proyectos = proyectoService.getProyectosPorNombre(nombre);
    return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

//proyectos/proyectos/nombre?nombre=Alexis para llamar en GET



}


 
