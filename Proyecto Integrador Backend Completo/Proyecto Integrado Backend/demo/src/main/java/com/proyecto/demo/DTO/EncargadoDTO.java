package com.proyecto.demo.DTO;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class EncargadoDTO {

    private int ID_ENCARGADO;
    private String NOMBRE;
    private String ROL;
    private ParticipantePDTO ID_PARTICIPANTE;



    private List<Rol_Proyecto_EncargadoDTO> rol_proyecto_encargado;
    private List<ActividadesDTO> actividadd;


    
}
