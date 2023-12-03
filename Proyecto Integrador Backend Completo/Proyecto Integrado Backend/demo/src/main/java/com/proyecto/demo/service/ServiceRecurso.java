package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.RecursoDTO;

public interface ServiceRecurso {

   List<RecursoDTO> getAll();
    RecursoDTO getById(int id);
    RecursoDTO create(RecursoDTO recursoDTO);
    RecursoDTO update(int id, RecursoDTO recursoDTO);
    void delete(int id);




    
}
