package com.proyecto.demo.MappersPersonalizados;

import com.proyecto.demo.DTOPersonalizados.Rol_ProyectoPDTO;
import com.proyecto.demo.entity.Rol_Proyecto;

public class Rol_ProyectoPMapper {



     public static Rol_ProyectoPDTO DatosAlDTO(Rol_Proyecto rol_proyecto) {
        Rol_ProyectoPDTO rol_proyectoDTO = new Rol_ProyectoPDTO();
        rol_proyectoDTO.setID_ROL_PROYECTO(rol_proyecto.getID_ROL_PROYECTO());
        rol_proyectoDTO.setHORA(rol_proyecto.getHORA());
        rol_proyectoDTO.setDESCRIPCION(rol_proyecto.getDESCRIPCION());

        return rol_proyectoDTO;
    }

        public static Rol_Proyecto DatosAlaEntidad(Rol_ProyectoPDTO rol_proyectoDTO) {
            Rol_Proyecto rol_proyecto = new Rol_Proyecto();
            rol_proyecto.setID_ROL_PROYECTO(rol_proyectoDTO.getID_ROL_PROYECTO());
            rol_proyecto.setHORA(rol_proyectoDTO.getHORA());
            rol_proyecto.setDESCRIPCION(rol_proyectoDTO.getDESCRIPCION());

            return rol_proyecto;
        }
    
}
