package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.ParticipanteDTO;

public interface ServiceParticipante {

    List<ParticipanteDTO> getAll();
    ParticipanteDTO getById(int id);
    ParticipanteDTO create(ParticipanteDTO participanteDTO);
    ParticipanteDTO update(int id, ParticipanteDTO participanteDTO);
    void delete(int id);



    
}
