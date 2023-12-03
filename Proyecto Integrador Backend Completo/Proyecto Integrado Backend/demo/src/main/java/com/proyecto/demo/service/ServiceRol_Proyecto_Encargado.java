package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.Rol_Proyecto_EncargadoDTO;

public interface ServiceRol_Proyecto_Encargado {

   List<Rol_Proyecto_EncargadoDTO> getAll();
    Rol_Proyecto_EncargadoDTO getById(int id);
    Rol_Proyecto_EncargadoDTO create(Rol_Proyecto_EncargadoDTO rol_Proyecto_EncargadoDTO);
    Rol_Proyecto_EncargadoDTO update(int id, Rol_Proyecto_EncargadoDTO rol_Proyecto_EncargadoDTO);
    void delete(int id);



    
}
