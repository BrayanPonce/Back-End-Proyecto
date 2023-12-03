package com.proyecto.demo.DTO;

import lombok.Data;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class RecursoDTO {

    private int ID_RECURSO;
    private String URL;
    private String NOMBRE;
    
    private ProyectoPersonalizadoDTO ID_PROYECTO;
}
