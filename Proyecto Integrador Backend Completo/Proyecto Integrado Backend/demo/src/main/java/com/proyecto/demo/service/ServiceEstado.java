package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.EstadoDTO;

public interface ServiceEstado {

          List<EstadoDTO> getAll();
    EstadoDTO getById(int id);
    EstadoDTO create(EstadoDTO estadoDTO);
    EstadoDTO update(int id, EstadoDTO estadoDTO);
    void delete(int id);


    
}
