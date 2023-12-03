package com.proyecto.demo.DTO;

import java.sql.Date;
import java.util.List;

import com.proyecto.demo.DTOPersonalizados.EncargadoPersonalizadoDTO;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;
import lombok.Data;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ActividadesDTO {

    private int ID_ACTIVIDAD;
    private String NOMBRE;
    private Date FECHA;
//------------------------------fks-------------------------------//

    private ProyectoPersonalizadoDTO ID_PROYECTO;

    private EncargadoPersonalizadoDTO ID_ENCARGADO;
//------------------------------Listas-------------------------------//

private List<Actividad_ParticipanteDTO> Actividad_Participante;
  
 
}
