package com.proyecto.demo.DTO;

import java.util.List;

import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;
import lombok.Data;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class Rol_ProyectoDTO {

    private int ID_ROL_PROYECTO;
    private int HORA;
    private String DESCRIPCION;

//------------------------------fks-------------------------------//

    private Rol_NegocioDTO ID_ROL_NEGOCIO;
    private ProyectoPersonalizadoDTO ID_PROYECTO;

//------------------------------Listas-------------------------------//

private List<Rol_Proyecto_EncargadoDTO> rol_proyecto_encargado;
    
}
