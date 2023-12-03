package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.Actividad_ParticipanteDTO;
import com.proyecto.demo.DTOPersonalizados.ActividadPDTO;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;
import com.proyecto.demo.MappersPersonalizados.ActividadPMapper;
import com.proyecto.demo.MappersPersonalizados.ParticipantePMapper;
import com.proyecto.demo.entity.Actividad;
import com.proyecto.demo.entity.Actividad_Participante;
import com.proyecto.demo.entity.Participante;

public class Actividad_ParticipanteMapper {

  public static Actividad_ParticipanteDTO DatosAlDTO(Actividad_Participante actividad_Participante){
       Actividad_ParticipanteDTO actividad_ParticipanteDTO = new Actividad_ParticipanteDTO();

       actividad_ParticipanteDTO.setID_ACTIVIDAD_PARTICIPANTE(actividad_Participante.getID_ACTIVIDAD_PARTICIPANTE());
       actividad_ParticipanteDTO.setAsistencia(actividad_Participante.isASISTENCIA());

//--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID PARTICIPANTE


            Participante participante = actividad_Participante.getParticipante();
        if (participante != null) {
        ParticipantePDTO participanteDTO = ParticipantePMapper.DatosAlDTO(participante);
                actividad_ParticipanteDTO.setID_PARTICIPANTE(participanteDTO);
        }

         
//-----------------------------------------------------ID Actividad


            Actividad actividad = actividad_Participante.getActividad();
        if (actividad != null) {
        ActividadPDTO actividadDTO = ActividadPMapper.DatosAlDTO(actividad);
                actividad_ParticipanteDTO.setID_ACTIVIDAD(actividadDTO);
        }


   


        return actividad_ParticipanteDTO;
    }



    public static Actividad_Participante DatosAlaEdentidad(Actividad_ParticipanteDTO actividad_ParticipanteDTO){

        Actividad_Participante actividad_Participante = new Actividad_Participante();
        actividad_Participante.setID_ACTIVIDAD_PARTICIPANTE(actividad_ParticipanteDTO.getID_ACTIVIDAD_PARTICIPANTE());
         actividad_Participante.setASISTENCIA(actividad_ParticipanteDTO.isAsistencia());

    //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Proyecto  
    ParticipantePDTO participanteDTO = actividad_ParticipanteDTO.getID_PARTICIPANTE();
    Participante participante = (participanteDTO != null) ? ParticipantePMapper.DatosAlaEdentidad(participanteDTO) : null;
    actividad_Participante.setParticipante(participante);

  
    //--------------------------------------------------------------------- Proyecto  
    ActividadPDTO actividadDTO = actividad_ParticipanteDTO.getID_ACTIVIDAD();
    Actividad actividad = (actividadDTO != null) ? ActividadPMapper.DatosAlaEntidad(actividadDTO) : null;
    actividad_Participante.setActividad(actividad);

     
       

        return actividad_Participante;

    }














    
}
