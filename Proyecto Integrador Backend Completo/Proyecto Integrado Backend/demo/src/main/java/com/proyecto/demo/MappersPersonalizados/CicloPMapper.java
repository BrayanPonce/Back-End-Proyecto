package com.proyecto.demo.MappersPersonalizados;

import com.proyecto.demo.DTOPersonalizados.CicloPDTO;
import com.proyecto.demo.entity.Ciclo;

public class CicloPMapper {


    public static CicloPDTO DatosAlDTO(Ciclo ciclo){
       CicloPDTO cicloDTO = new CicloPDTO();

       cicloDTO.setID_CICLO(ciclo.getID_CICLO());
       cicloDTO.setNOMBRE(ciclo.getNOMBRE()); 
        return cicloDTO;
    }



    public static Ciclo DatosAlaEdentidad(CicloPDTO cicloDTO){

     Ciclo ciclo = new Ciclo();
        ciclo.setID_CICLO(cicloDTO.getID_CICLO());
        return ciclo;

    }
    
    
}
