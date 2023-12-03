package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.Rol_NegocioDTO;


public interface ServiceRol_Negocio {

   List<Rol_NegocioDTO> getAll();
    Rol_NegocioDTO getById(int id);
    Rol_NegocioDTO create(Rol_NegocioDTO rol_negocioDTO);
    Rol_NegocioDTO update(int id, Rol_NegocioDTO rol_negocioDTO);
    void delete(int id);




    
}
