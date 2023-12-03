package com.proyecto.demo.DTO;

import lombok.Data;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class Rol_Sistema_AccesosDTO {

    private int ID_ROL_SISTEMA_ACCESOS;


    private Rol_SistemaDTO ID_ROL_SISTEMA;


    private AccesoDTO ID_ACCESOS;

    
}
