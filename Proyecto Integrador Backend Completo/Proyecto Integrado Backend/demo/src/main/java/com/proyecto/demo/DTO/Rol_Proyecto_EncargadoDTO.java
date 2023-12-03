package com.proyecto.demo.DTO;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.proyecto.demo.DTOPersonalizados.EncargadoPersonalizadoDTO;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;
import com.proyecto.demo.DTOPersonalizados.Rol_ProyectoPDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class Rol_Proyecto_EncargadoDTO {

    private int ID_ROL_PROYECTO_ENCARGADO;


    private Rol_ProyectoPDTO ID_ROL_PROYECTO;


    private EncargadoPersonalizadoDTO ID_ENCARGADO;



   private List<ParticipantePDTO> participante;


    
}
