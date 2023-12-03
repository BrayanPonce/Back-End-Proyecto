package com.proyecto.demo.MappersPersonalizados;

import com.proyecto.demo.DTOPersonalizados.EncargadoPersonalizadoDTO;
import com.proyecto.demo.entity.Encargado;

public class EncargadoMapperPersonalizado {


    
    public static EncargadoPersonalizadoDTO DatosAlDTO(Encargado encargado){
       EncargadoPersonalizadoDTO encargadoPersonalizadoDTO = new EncargadoPersonalizadoDTO();

       encargadoPersonalizadoDTO.setID_ENCARGADO(encargado.getID_ENCARGADO());
       encargadoPersonalizadoDTO.setNOMBRE(encargado.getNOMBRE()); 
       encargadoPersonalizadoDTO.setROL(encargado.getROL()); 


        return encargadoPersonalizadoDTO;
    }



    public static Encargado DatosAlaEdentidad(EncargadoPersonalizadoDTO encargadoPersonalizadoDTO){

        Encargado encargado = new Encargado();
        encargado.setID_ENCARGADO(encargadoPersonalizadoDTO.getID_ENCARGADO());
        return encargado;

    }

    
}
