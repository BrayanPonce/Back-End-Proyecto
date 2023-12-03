package com.proyecto.demo.DTOPersonalizados;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CicloPDTO {

    private int ID_CICLO;
    private String NOMBRE;
    
}
