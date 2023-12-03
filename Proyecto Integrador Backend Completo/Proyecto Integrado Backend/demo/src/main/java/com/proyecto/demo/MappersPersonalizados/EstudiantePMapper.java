package com.proyecto.demo.MappersPersonalizados;

import com.proyecto.demo.DTOPersonalizados.EstudiantePDTO;
import com.proyecto.demo.entity.Estudiante;

public class EstudiantePMapper {



   
    public static EstudiantePDTO DatosAlDTO(Estudiante estudiante){
       EstudiantePDTO estudianteDTO = new EstudiantePDTO();

       estudianteDTO.setID_ESTUDIANTE(estudiante.getID_ESTUDIANTE());
       estudianteDTO.setCODIGO(estudiante.getCODIGO());
        estudianteDTO.setHORAS_TOTALES(estudiante.getHORAS_TOTALES());


        return estudianteDTO;
    }



    public static Estudiante DatosAlaEdentidad(EstudiantePDTO estudianteDTO){

        Estudiante estudiante = new Estudiante();
        estudiante.setID_ESTUDIANTE(estudianteDTO.getID_ESTUDIANTE());
        estudiante.setCODIGO(estudianteDTO.getCODIGO());
        estudiante.setHORAS_TOTALES(estudianteDTO.getHORAS_TOTALES());

        return estudiante;

    }















    
}
