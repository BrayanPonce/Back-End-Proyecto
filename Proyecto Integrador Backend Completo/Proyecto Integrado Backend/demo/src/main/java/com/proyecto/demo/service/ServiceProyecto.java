package com.proyecto.demo.service;

import java.util.List;

import com.proyecto.demo.DTO.ProyectoDTO;

public interface ServiceProyecto {

    List<ProyectoDTO> getAllProyectos();
    ProyectoDTO getProyectoById(int id);
    ProyectoDTO createProyecto(ProyectoDTO proyectoDTO);
    ProyectoDTO updateProyecto(int id, ProyectoDTO proyectoDTO);
    void deleteProyecto(int id);
    List<ProyectoDTO> getProyectosPorNombre(String nombre);



    
}
