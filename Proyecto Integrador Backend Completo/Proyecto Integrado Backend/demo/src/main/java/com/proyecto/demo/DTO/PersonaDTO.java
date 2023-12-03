package com.proyecto.demo.DTO;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.proyecto.demo.DTOPersonalizados.CursoArticuladoPDTO;
import com.proyecto.demo.DTOPersonalizados.DocentePDTO;
import com.proyecto.demo.DTOPersonalizados.EstudiantePDTO;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class PersonaDTO {

    private int ID_PERSONA;
    private String NOMBRE;
    private String DNI;
    private Rol_SistemaDTO ID_ROL_SISTEMA;







  
    private List<EstudiantePDTO> estudiantes;

   
    private List<CursoArticuladoPDTO> cursoarticulado;
    
   
   private  List<ParticipantePDTO> participante;
    
    
   private  List<Usuario_AccesosDTO> usuario_accesos;

    
   private  List<DocentePDTO> docente;
    
    
    
}
