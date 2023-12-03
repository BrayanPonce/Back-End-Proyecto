package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.EncargadoDTO;

public interface ServiceEncargado {

         List<EncargadoDTO> getAll();
    EncargadoDTO getById(int id);
    EncargadoDTO create(EncargadoDTO encargadoDTO);
    EncargadoDTO update(int id , EncargadoDTO encargadoDTO);
    void delete(int id);

    
}
