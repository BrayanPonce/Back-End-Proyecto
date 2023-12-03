package com.proyecto.demo.DTOPersonalizados;



import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data

public class ParticipantePDTO {


    private int ID_PARTICIPANTE;
    
}
