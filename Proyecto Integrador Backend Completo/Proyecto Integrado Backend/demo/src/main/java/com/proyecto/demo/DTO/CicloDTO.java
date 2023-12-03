package com.proyecto.demo.DTO;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.proyecto.demo.DTOPersonalizados.EscuelaPDTO;
import com.proyecto.demo.DTOPersonalizados.EstudiantePDTO;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class CicloDTO {
    
    private int ID_CICLO;
    private String NOMBRE;
    private EscuelaPDTO ID_ESCUELA;

    private List<EstudiantePDTO> estudiante;
    private List<ProyectoPersonalizadoDTO> proyecto;
    
}
