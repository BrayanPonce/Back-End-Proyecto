package com.proyecto.demo.DTO;

import lombok.Data;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data

public class EstadoDTO {
    private int ID_ESTADO;
    private String NOMBRE;
    
}
