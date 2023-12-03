package com.proyecto.demo.MappersPersonalizados;

import com.proyecto.demo.DTOPersonalizados.ActividadPDTO;
import com.proyecto.demo.entity.Actividad;

public class ActividadPMapper {


      public static Actividad DatosAlaEntidad(ActividadPDTO actividadesDTO) {
        Actividad actividad = new Actividad();
        actividad.setID_ACTIVIDAD(actividadesDTO.getID_ACTIVIDAD());
        actividad.setNOMBRE(actividadesDTO.getNOMBRE());
         actividad.setFECHA(actividadesDTO.getFECHA());

         return actividad;
      }


      public static ActividadPDTO DatosAlDTO(Actividad actividad) {
        ActividadPDTO actividadDTO = new ActividadPDTO();
       actividadDTO.setID_ACTIVIDAD(actividad.getID_ACTIVIDAD());
        actividadDTO.setNOMBRE(actividad.getNOMBRE());
        actividadDTO.setFECHA(actividad.getFECHA());

        return actividadDTO;

    }
    
    
}
