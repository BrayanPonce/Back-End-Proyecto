package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.Rol_SistemaDTO;

public interface ServiceRol_Sistema {

    List<Rol_SistemaDTO> getAll();
    Rol_SistemaDTO getById(int id);
    Rol_SistemaDTO create(Rol_SistemaDTO rol_SistemaDTO);
    Rol_SistemaDTO update(int id, Rol_SistemaDTO rol_SistemaDTO);
    void delete(int id);



    
}
