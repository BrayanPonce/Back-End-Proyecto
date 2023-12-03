package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.FacultadDTO;

public interface ServiceFacultad {

List<FacultadDTO> getAll();
    FacultadDTO getById(int id);
    FacultadDTO create(FacultadDTO facultadDTO);
    FacultadDTO update(int id, FacultadDTO facultadDTO);
    void delete(int id);



    
}
