package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.CursoArticuladoDTO;


public interface ServiceCursoArticulado {

         List<CursoArticuladoDTO> getAll();
    CursoArticuladoDTO getById(int id);
    CursoArticuladoDTO create(CursoArticuladoDTO cursoArticuladoDTO);
    CursoArticuladoDTO update(int id, CursoArticuladoDTO cursoArticulado);
    void delete(int id);


    
}
