package com.proyecto.demo.DTOPersonalizados;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data

public class Rol_ProyectoPDTO {


    private int ID_ROL_PROYECTO;
    private int HORA;
    private String DESCRIPCION;
    
}
