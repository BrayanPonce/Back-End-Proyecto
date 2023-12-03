package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.EstadoDTO;
import com.proyecto.demo.entity.Estado;

public class EstadoMapper {

    public static EstadoDTO DatosAlDTO(Estado estado){
       EstadoDTO estadoDTO = new EstadoDTO();

       estadoDTO.setID_ESTADO(estado.getID_ESTADO());
       estadoDTO.setNOMBRE(estado.getNOMBRE()); 


        return estadoDTO;
    }



    public static Estado DatosAlaEdentidad(EstadoDTO estadoDTO){

        Estado estado = new Estado();
        estado.setID_ESTADO(estadoDTO.getID_ESTADO());
        estado.setNOMBRE(estadoDTO.getNOMBRE());

        return estado;

    }


  
}












