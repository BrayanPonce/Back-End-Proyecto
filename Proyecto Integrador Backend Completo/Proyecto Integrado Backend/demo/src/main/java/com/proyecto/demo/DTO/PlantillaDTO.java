package com.proyecto.demo.DTO;

import lombok.Data;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class PlantillaDTO {

    private int ID_PLANTILLA;
    private String URL;
    private String NOMBRE;
    
    private Tipo_De_ConvenioDTO ID_TIPO_DE_CONVENIO;
}
