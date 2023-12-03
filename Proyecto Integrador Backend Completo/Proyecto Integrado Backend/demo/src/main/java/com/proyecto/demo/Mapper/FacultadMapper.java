package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.FacultadDTO;
import com.proyecto.demo.entity.Facultad;

public class FacultadMapper {

    
    public static FacultadDTO DatosAlDTO(Facultad facultad){
       FacultadDTO facultadDTO = new FacultadDTO();

       facultadDTO.setID_FACULTAD(facultad.getID_FACULTAD());
       facultadDTO.setNOMBRE(facultad.getNOMBRE()); 


        return facultadDTO;
    }



    public static Facultad DatosAlaEdentidad(FacultadDTO facultadDTO){

        Facultad facultad = new Facultad();
        facultad.setID_FACULTAD(facultadDTO.getID_FACULTAD());
        facultad.setNOMBRE(facultadDTO.getNOMBRE());

        return facultad;

    }
    
}
