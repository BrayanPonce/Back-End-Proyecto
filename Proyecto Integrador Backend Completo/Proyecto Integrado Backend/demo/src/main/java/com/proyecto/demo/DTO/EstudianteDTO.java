package com.proyecto.demo.DTO;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class EstudianteDTO {

    private int ID_ESTUDIANTE;
   
    private String CODIGO;
    private int HORAS_TOTALES;



    private Grupo_UnivDTO ID_GRUPO_UNIV;
    private CicloDTO ID_CICLO;
     private PersonaDTO ID_PERSONA;

     List<ParticipantePDTO> participante;
    
}
