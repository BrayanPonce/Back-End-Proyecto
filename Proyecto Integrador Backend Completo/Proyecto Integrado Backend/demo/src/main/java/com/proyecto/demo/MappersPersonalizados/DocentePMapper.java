package com.proyecto.demo.MappersPersonalizados;

import com.proyecto.demo.DTOPersonalizados.DocentePDTO;
import com.proyecto.demo.entity.Docente;

public class DocentePMapper {






       public static DocentePDTO DatosAlDTO(Docente docente){
       DocentePDTO docenteDTO = new DocentePDTO();
       return docenteDTO;
    }
    

    public static Docente DatosAlaEdentidad(DocentePDTO docenteDTO){

        Docente docente = new Docente();
        docente.setID_DOCENTE(docenteDTO.getID_DOCENTE());

        return docente;

    }
}
