package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.AccesoDTO;

public interface ServiceAcceso {

         List<AccesoDTO> getAll();
    AccesoDTO getById(int id);
    AccesoDTO create(AccesoDTO accesoDTO);
    AccesoDTO update(int id, AccesoDTO accesoDTO);
    void delete(int id);



    
}
