package com.proyecto.demo.MappersPersonalizados;

import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;
import com.proyecto.demo.entity.Participante;

public class ParticipantePMapper {



      public static ParticipantePDTO DatosAlDTO(Participante participante) {
    ParticipantePDTO participanteDTO = new ParticipantePDTO();
    participanteDTO.setID_PARTICIPANTE(participante.getID_PARTICIPANTE());

    return participanteDTO;
      }


       public static Participante DatosAlaEdentidad(ParticipantePDTO participanteDTO){

        Participante participante = new Participante();
        participante.setID_PARTICIPANTE(participanteDTO.getID_PARTICIPANTE());
    

        return participante;

    }
    
}
