package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.Grupo_UnivDTO;

public interface ServiceGrupo_Univ {

     List<Grupo_UnivDTO> getAll();
    Grupo_UnivDTO getById(int id);
    Grupo_UnivDTO create(Grupo_UnivDTO grupo_UnivDTO);
    Grupo_UnivDTO update(int id, Grupo_UnivDTO grupo_UnivDTO);
    void delete(int id);



    
}
