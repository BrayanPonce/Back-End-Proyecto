package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.Rol_SistemaDTO;
import com.proyecto.demo.entity.Rol_Sistema;

public class Rol_SistemaMapper {

 public static Rol_SistemaDTO DatosAlDTO(Rol_Sistema rol_Sistema){
       Rol_SistemaDTO rol_SistemaDTO = new Rol_SistemaDTO();

       rol_SistemaDTO.setID_ROL_SISTEMA(rol_Sistema.getID_ROL_SISTEMA());
    //    rol_SistemaDTO.setNOMBRE(rol_Sistema.getNOMBRE()); 


        return rol_SistemaDTO;
    }



    public static Rol_Sistema DatosAlaEdentidad(Rol_SistemaDTO rol_SistemaDTO){

        Rol_Sistema rol_Sistema = new Rol_Sistema();
        rol_Sistema.setID_ROL_SISTEMA(rol_SistemaDTO.getID_ROL_SISTEMA());
        // rol_Sistema.setNOMBRE(rol_SistemaDTO.getNOMBRE());

        return rol_Sistema;

    }





    
}
