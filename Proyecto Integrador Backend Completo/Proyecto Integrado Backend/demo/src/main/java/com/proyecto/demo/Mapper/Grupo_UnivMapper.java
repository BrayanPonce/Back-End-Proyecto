package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.Grupo_UnivDTO;
import com.proyecto.demo.entity.Grupo_Univ;

public class Grupo_UnivMapper {

    
    public static Grupo_UnivDTO DatosAlDTO(Grupo_Univ grupo_Univ){
       Grupo_UnivDTO grupo_UnivDTO = new Grupo_UnivDTO();

       grupo_UnivDTO.setID_GRUPO_UNIV(grupo_Univ.getID_GRUPO_UNIV());
       grupo_UnivDTO.setNOMBRE(grupo_Univ.getNOMBRE()); 


        return grupo_UnivDTO;
    }



    public static Grupo_Univ DatosAlaEdentidad(Grupo_UnivDTO grupo_UnivDTO){

        Grupo_Univ grupo_Univ = new Grupo_Univ();
        grupo_Univ.setID_GRUPO_UNIV(grupo_UnivDTO.getID_GRUPO_UNIV());
        grupo_Univ.setNOMBRE(grupo_UnivDTO.getNOMBRE());
       

        return grupo_Univ;

    }
    
}
