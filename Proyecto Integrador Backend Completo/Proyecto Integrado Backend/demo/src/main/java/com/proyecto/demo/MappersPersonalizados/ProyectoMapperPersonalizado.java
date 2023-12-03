package com.proyecto.demo.MappersPersonalizados;

import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;
import com.proyecto.demo.entity.Proyecto;

public class ProyectoMapperPersonalizado {
    public static ProyectoPersonalizadoDTO DatosAlDTO(Proyecto proyecto) {
        ProyectoPersonalizadoDTO proyectopersonzalizadoDTO = new ProyectoPersonalizadoDTO();
        proyectopersonzalizadoDTO.setID_PROYECTO(proyecto.getID_PROYECTO());
        proyectopersonzalizadoDTO.setNOMBRE(proyecto.getNOMBRE());
        return proyectopersonzalizadoDTO;
    }

    public static Proyecto DatosAlaEdentidad(ProyectoPersonalizadoDTO proyectopersonzalizadoDTO) {
        Proyecto proyecto = new Proyecto();
        proyecto.setID_PROYECTO(proyectopersonzalizadoDTO.getID_PROYECTO());
 
        return proyecto;
    }
    
}