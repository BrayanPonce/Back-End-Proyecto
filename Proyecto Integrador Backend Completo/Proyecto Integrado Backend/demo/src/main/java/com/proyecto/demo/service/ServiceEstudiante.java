package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.EstudianteDTO;

public interface ServiceEstudiante {

List<EstudianteDTO> getAll();
    EstudianteDTO getById(int id);
    EstudianteDTO create(EstudianteDTO estudianteDTO);
    EstudianteDTO update(int id, EstudianteDTO estudianteDTO);
    void delete(int id);


    
}
