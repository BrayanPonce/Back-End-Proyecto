package com.proyecto.demo.DTO;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.proyecto.demo.DTOPersonalizados.EscuelaPDTO;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class CursoArticuladoDTO {

    private int ID_CURSO_ARTICULADO;
    private String NOMBRE;
     private EscuelaPDTO ID_ESCUELA;
    private PersonaDTO ID_PERSONA;
    private DocenteDTO ID_DOCENTE;
    

    private List<ProyectoPersonalizadoDTO> proyecto;
    
}
