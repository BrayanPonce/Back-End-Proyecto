package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.Tipo_De_ConvenioDTO;
import com.proyecto.demo.entity.Tipo_De_Convenio;

public class Tipo_De_ConvenioMapper {


    public static Tipo_De_ConvenioDTO DatosAlDTO(Tipo_De_Convenio tipo_De_Convenio){

        Tipo_De_ConvenioDTO tipo_De_ConvenioDTO = new Tipo_De_ConvenioDTO();

        tipo_De_ConvenioDTO.setID_TIPO_DE_CONVENIO(tipo_De_Convenio.getID_TIPO_DE_CONVENIO());
        tipo_De_ConvenioDTO.setNOMBRE(tipo_De_Convenio.getNOMBRE());


        return tipo_De_ConvenioDTO;
    }

    public static Tipo_De_Convenio DatosAlaEdentidad(Tipo_De_ConvenioDTO tipo_De_ConvenioDTO){

        Tipo_De_Convenio tipo_De_Convenio = new Tipo_De_Convenio();

     tipo_De_Convenio.setID_TIPO_DE_CONVENIO(tipo_De_ConvenioDTO.getID_TIPO_DE_CONVENIO());
    
        tipo_De_Convenio.setNOMBRE(tipo_De_ConvenioDTO.getNOMBRE());


        return tipo_De_Convenio;

    }
    
}
