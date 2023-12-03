package com.proyecto.demo.DTO;

import lombok.Data;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class UsuarioDTO {
    private int ID_USUARIO;
    private String USERNAME;
    private String PASSWORD;

    private PersonaDTO ID_PERSONA;

    
}
