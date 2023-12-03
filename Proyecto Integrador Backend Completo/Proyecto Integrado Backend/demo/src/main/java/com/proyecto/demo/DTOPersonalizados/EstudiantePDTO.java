package com.proyecto.demo.DTOPersonalizados;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data

public class EstudiantePDTO {





    private int ID_ESTUDIANTE;
    private String CODIGO;
    private int HORAS_TOTALES;
    
}
