package com.proyecto.demo.service;

import java.util.List;



import com.proyecto.demo.DTO.SemestreDTO;

public interface ServiceSemestre {

        List<SemestreDTO> getAllSemestre();
    SemestreDTO getSemestreById(int id);
    SemestreDTO createSemestre(SemestreDTO semestreDTO);
    SemestreDTO updateSemestre(int id, SemestreDTO semestreDTO);
    void deleteSemestre(int id);
    List<SemestreDTO> getSemestrePorNombre(String nombre);




    
}
