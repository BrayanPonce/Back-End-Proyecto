package com.proyecto.demo.DTOPersonalizados;





import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data

public class EscuelaPDTO {



    private int ID_ESCUELA;
    private String NOMBRE;
    
}
