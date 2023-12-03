package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.AccesoDTO;
import com.proyecto.demo.entity.Acceso;

public class AccesoMapper {

    public static AccesoDTO DatosAlDTO(Acceso acceso){
       AccesoDTO accesoDTO = new AccesoDTO();

       accesoDTO.setID_ACCESOS(acceso.getID_ACCESOS());
       accesoDTO.setNOMBRE(acceso.getNOMBRE()); 
       accesoDTO.setURL(acceso.getURL()); 
       accesoDTO.setID_ACCESOS_PADRE(acceso.getID_ACCESOS_PADRE()); 


        return accesoDTO;
    }



    public static Acceso DatosAlaEdentidad(AccesoDTO accesoDTO){

        Acceso acceso = new Acceso();
        acceso.setID_ACCESOS(accesoDTO.getID_ACCESOS());
        acceso.setNOMBRE(accesoDTO.getNOMBRE());
        acceso.setURL(accesoDTO.getURL());
        acceso.setID_ACCESOS_PADRE(accesoDTO.getID_ACCESOS_PADRE());

        return acceso;

    }



    
}
