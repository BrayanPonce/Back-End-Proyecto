package com.proyecto.demo.DTO;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class EscuelaDTO {

    private int ID_ESCUELA;
    private FacultadDTO ID_FACULTAD;
    private String NOMBRE;




    private List<ProyectoPersonalizadoDTO> PROYECTO;
    private List<CicloDTO> ciclo;
     private List<CursoArticuladoDTO> CursoArticulado;
    
}
