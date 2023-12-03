package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.DocenteDTO;

public interface ServiceDocente {

        List<DocenteDTO> getAll();
    DocenteDTO getById(int id);
    DocenteDTO create(DocenteDTO docenteDTO);
    DocenteDTO update(int id, DocenteDTO docenteDTO);
    void delete(int id);



    
}
