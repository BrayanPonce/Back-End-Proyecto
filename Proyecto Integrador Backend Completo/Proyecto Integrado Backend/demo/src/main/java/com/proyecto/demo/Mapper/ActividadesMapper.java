package com.proyecto.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.demo.DTO.Actividad_ParticipanteDTO;
import com.proyecto.demo.DTO.ActividadesDTO;
import com.proyecto.demo.DTOPersonalizados.EncargadoPersonalizadoDTO;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;
import com.proyecto.demo.MappersPersonalizados.EncargadoMapperPersonalizado;
import com.proyecto.demo.MappersPersonalizados.ProyectoMapperPersonalizado;
import com.proyecto.demo.entity.Actividad;
import com.proyecto.demo.entity.Encargado;
import com.proyecto.demo.entity.Proyecto;

public class ActividadesMapper {

     public static Actividad DatosAlaEntidad(ActividadesDTO actividadesDTO) {
        Actividad actividad = new Actividad();
        actividad.setID_ACTIVIDAD(actividadesDTO.getID_ACTIVIDAD());
        actividad.setNOMBRE(actividadesDTO.getNOMBRE());
         actividad.setFECHA(actividadesDTO.getFECHA());


        
         //--------------------------------------- IDS QUE JALA ---------------------------------//
  //--------------------------------------------------------------------- Proyecto  
    ProyectoPersonalizadoDTO proyectoPersonalizadoDTO = actividadesDTO.getID_PROYECTO();
    Proyecto proyecto = (proyectoPersonalizadoDTO != null) ? ProyectoMapperPersonalizado.DatosAlaEdentidad(proyectoPersonalizadoDTO) : null;
    actividad.setProyecto(proyecto);

     //--------------------------------------------------------------------- Encargado
        EncargadoPersonalizadoDTO encargadoDTO = actividadesDTO.getID_ENCARGADO();
        Encargado encargado = (encargadoDTO != null) ? EncargadoMapperPersonalizado.DatosAlaEdentidad(encargadoDTO) : null;
        actividad.setEncargado(encargado);   
    
       

    //--------------------------------------------------------------------- Termina ids que jala------------------------------------------------------------------------

  



    return actividad;
    }



    public static ActividadesDTO DatosAlDTO(Actividad actividad) {
        ActividadesDTO actividadDTO = new ActividadesDTO();
       actividadDTO.setID_ACTIVIDAD(actividad.getID_ACTIVIDAD());
        actividadDTO.setNOMBRE(actividad.getNOMBRE());
        actividadDTO.setFECHA(actividad.getFECHA());

            //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio
        //-----------------------------------------------------ID PROYECTO


          Proyecto proyecto = actividad.getProyecto();
        if (proyecto != null) {
            ProyectoPersonalizadoDTO proyectoDTO = ProyectoMapperPersonalizado.DatosAlDTO(proyecto);
            actividadDTO.setID_PROYECTO(proyectoDTO);
        }

    //-----------------------------------------------------ID Encargado

         Encargado encargado = actividad.getEncargado();
             if (encargado != null) {
        EncargadoPersonalizadoDTO encargadoPersonalizadoDTO = EncargadoMapperPersonalizado.DatosAlDTO(encargado);
             actividadDTO.setID_ENCARGADO(encargadoPersonalizadoDTO);
    }
     
    //----------------------------------------------------------------Listas Que jala  -----------------------------------------------------------------------    
      //----------------------------------------------------------------Actividad_Participante

        List<Actividad_ParticipanteDTO> actividad_participanteDTO = actividad.getActividad_Participante().stream()
        .map(Actividad_ParticipanteMapper::DatosAlDTO)
        .collect(Collectors.toList());
        actividadDTO.setActividad_Participante(actividad_participanteDTO); 

        return actividadDTO;

    }
    
}
