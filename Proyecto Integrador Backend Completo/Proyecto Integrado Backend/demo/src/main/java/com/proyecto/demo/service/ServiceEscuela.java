package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.EscuelaDTO;

public interface ServiceEscuela {

       
    List<EscuelaDTO> getAllEscuela();
    EscuelaDTO getEscuelaById(int id);
    EscuelaDTO createEscuela(EscuelaDTO escuelaDTO);
    EscuelaDTO updateEscuela(int id, EscuelaDTO escuelaDTO);
    void deleteEscuela(int id);
   

    
}
