package com.proyecto.demo.DTO;

import lombok.Data;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class Usuario_AccesosDTO {
    private int ID_USUARIO_ACCESOS;


    private UsuarioDTO ID_USUARIO;


    private AccesoDTO ID_ACCESOS;
    
}
