package com.proyecto.demo.DTOPersonalizados;

import lombok.Data;




import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ProyectoPersonalizadoDTO {
    private int ID_PROYECTO;
    private String NOMBRE;

}
