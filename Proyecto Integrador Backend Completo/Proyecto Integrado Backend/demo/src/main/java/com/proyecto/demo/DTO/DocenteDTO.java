package com.proyecto.demo.DTO;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.proyecto.demo.DTOPersonalizados.CursoArticuladoPDTO;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data

public class DocenteDTO {

    private int ID_DOCENTE;

    private PersonaDTO ID_PERSONA;







    private List<ParticipantePDTO> participante;
    private List<CursoArticuladoPDTO> curso_articulado;


}
