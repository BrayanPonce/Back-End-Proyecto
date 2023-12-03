package com.proyecto.demo.DTO;
import lombok.Data;



import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class Tipo_De_ConvenioDTO {

    private int ID_TIPO_DE_CONVENIO;
    private String NOMBRE;





}
