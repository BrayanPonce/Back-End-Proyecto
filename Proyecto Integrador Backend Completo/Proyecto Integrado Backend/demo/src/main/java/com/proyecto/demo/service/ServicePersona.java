package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.PersonaDTO;

public interface ServicePersona {

   List<PersonaDTO> getAll();
    PersonaDTO getById(int id);
    PersonaDTO create(PersonaDTO personaDTO);
    PersonaDTO update(int id, PersonaDTO personaDTO);
    void delete(int id);




    
}
