package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.Rol_Sistema_AccesosDTO;

public interface ServiceRol_Sistema_Accesos {

   List<Rol_Sistema_AccesosDTO> getAll();
    Rol_Sistema_AccesosDTO getById(int id);
    Rol_Sistema_AccesosDTO create(Rol_Sistema_AccesosDTO rol_Sistema_AccesosDTO);
    Rol_Sistema_AccesosDTO update(int id, Rol_Sistema_AccesosDTO rol_Sistema_AccesosDTO);
    void delete(int id);



    
}
