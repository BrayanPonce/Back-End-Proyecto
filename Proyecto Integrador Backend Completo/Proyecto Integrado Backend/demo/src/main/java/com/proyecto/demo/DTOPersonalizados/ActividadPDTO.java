package com.proyecto.demo.DTOPersonalizados;

import java.sql.Date;

import lombok.Data;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data

public class ActividadPDTO {


    private int ID_ACTIVIDAD;
    private String NOMBRE;
    private Date FECHA;
    
}
