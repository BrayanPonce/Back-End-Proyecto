package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.Rol_ProyectoDTO;

public interface ServiceRol_Proyecto {

       List<Rol_ProyectoDTO> getAll();
    Rol_ProyectoDTO getById(int id);
    Rol_ProyectoDTO create(Rol_ProyectoDTO rol_ProyectoDTO);
    Rol_ProyectoDTO update(int id, Rol_ProyectoDTO rol_ProyectoDTO);
    void delete(int id);



    
}
