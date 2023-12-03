package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.Actividad_ParticipanteDTO;


public interface ServiceActividad_Participante {

     List<Actividad_ParticipanteDTO> getAll();
    Actividad_ParticipanteDTO getById(int id);
    Actividad_ParticipanteDTO create(Actividad_ParticipanteDTO actividad_ParticipanteDTO);
    Actividad_ParticipanteDTO update(int id, Actividad_ParticipanteDTO actividad_ParticipanteDTO);
    void delete(int id);



    
}
