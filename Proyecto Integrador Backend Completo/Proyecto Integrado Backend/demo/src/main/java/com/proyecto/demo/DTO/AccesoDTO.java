package com.proyecto.demo.DTO;

import lombok.Data;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class AccesoDTO {

    private int ID_ACCESOS;
    private String NOMBRE;
    private String URL;

    private Integer ID_ACCESOS_PADRE;



    
}
