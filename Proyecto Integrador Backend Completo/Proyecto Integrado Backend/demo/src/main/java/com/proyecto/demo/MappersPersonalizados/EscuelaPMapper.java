package com.proyecto.demo.MappersPersonalizados;

import com.proyecto.demo.DTOPersonalizados.EscuelaPDTO;
import com.proyecto.demo.entity.Escuela;

public class EscuelaPMapper {


    

    public static EscuelaPDTO DatosAlDTO(Escuela escuela){

        EscuelaPDTO escuelaDTO = new EscuelaPDTO();

        escuelaDTO.setID_ESCUELA(escuela.getID_ESCUELA());
        escuelaDTO.setNOMBRE(escuela.getNOMBRE());

        return escuelaDTO;
    }

    public static Escuela DatosAlaEdentidad(EscuelaPDTO escuelaDTO){

        Escuela escuela = new Escuela();

    escuela.setID_ESCUELA(escuelaDTO.getID_ESCUELA());
        escuela.setNOMBRE(escuelaDTO.getNOMBRE());

        return escuela;

    }
    









    
}
