package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.Rol_NegocioDTO;
import com.proyecto.demo.entity.Rol_Negocio;

public class Rol_NegocioMapper {
    
     public static  Rol_NegocioDTO DatosAlDTO( Rol_Negocio rol_negocio){
        Rol_NegocioDTO rol_negocioDTO = new  Rol_NegocioDTO();

       rol_negocioDTO.setID_ROL_NEGOCIO(rol_negocio.getID_ROL_NEGOCIO());
       rol_negocioDTO.setNOMBRE(rol_negocio.getNOMBRE()); 


        return rol_negocioDTO;
    }



    public static  Rol_Negocio DatosAlaEdentidad( Rol_NegocioDTO rol_negocioDTO){

         Rol_Negocio rol_negocio = new Rol_Negocio();
        rol_negocio.setID_ROL_NEGOCIO(rol_negocioDTO.getID_ROL_NEGOCIO());
        rol_negocio.setNOMBRE(rol_negocioDTO.getNOMBRE());

        return rol_negocio;

    }
    
}
