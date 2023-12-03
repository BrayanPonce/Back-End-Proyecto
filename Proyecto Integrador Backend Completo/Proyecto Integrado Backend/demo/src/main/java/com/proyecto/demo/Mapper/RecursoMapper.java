package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.RecursoDTO;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;
import com.proyecto.demo.MappersPersonalizados.ProyectoMapperPersonalizado;
import com.proyecto.demo.entity.Proyecto;
import com.proyecto.demo.entity.Recurso;

public class RecursoMapper {
  
  
  
      public static RecursoDTO entidadADTO(Recurso recurso) {
          RecursoDTO recursoDTO = new RecursoDTO();
        recursoDTO.setID_RECURSO(recurso.getID_RECURSO());
          recursoDTO.setNOMBRE(recurso.getNOMBRE());
          recursoDTO.setURL(recurso.getURL());
          //--------------------------------------- IDS QUE JALA ---------------------------------//
   
  //-----------------------------------------------------ID proyecto
  
  
  Proyecto proyecto = recurso.getProyecto();
  if (proyecto != null) {
      ProyectoPersonalizadoDTO proyectoDTO = ProyectoMapperPersonalizado.DatosAlDTO(proyecto);
      recursoDTO.setID_PROYECTO(proyectoDTO);
  }
          return recursoDTO;
  
      }







      public static Recurso DatosAlaEntidad(RecursoDTO recursoDTO) {
        Recurso recurso = new Recurso();
        recurso.setID_RECURSO(recursoDTO.getID_RECURSO());
        recurso.setNOMBRE(recursoDTO.getNOMBRE());
        recurso.setURL(recursoDTO.getURL());
            //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Proyecto  
    ProyectoPersonalizadoDTO proyectoDTO = recursoDTO.getID_PROYECTO();
    Proyecto proyecto = (proyectoDTO != null) ? ProyectoMapperPersonalizado.DatosAlaEdentidad(proyectoDTO) : null;
    recurso.setProyecto(proyecto);




      
        return recurso;
    }


    
}
