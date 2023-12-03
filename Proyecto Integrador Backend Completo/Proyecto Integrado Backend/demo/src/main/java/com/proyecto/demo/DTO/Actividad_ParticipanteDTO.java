package com.proyecto.demo.DTO;

import lombok.Data;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.proyecto.demo.DTOPersonalizados.ActividadPDTO;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class Actividad_ParticipanteDTO {



    private int ID_ACTIVIDAD_PARTICIPANTE;
    private boolean asistencia;


    private ParticipantePDTO ID_PARTICIPANTE;


    private ActividadPDTO ID_ACTIVIDAD;

    
}
