package com.proyecto.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.demo.DTO.DocenteDTO;
import com.proyecto.demo.DTO.PersonaDTO;
import com.proyecto.demo.DTOPersonalizados.CursoArticuladoPDTO;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;
import com.proyecto.demo.MappersPersonalizados.Curso_ArticuladoPMapper;
import com.proyecto.demo.MappersPersonalizados.ParticipantePMapper;
import com.proyecto.demo.entity.Docente;
import com.proyecto.demo.entity.Persona;

public class DocenteMapper {

    
    public static DocenteDTO DatosAlDTO(Docente docente){
       DocenteDTO docenteDTO = new DocenteDTO();

       docenteDTO.setID_DOCENTE(docente.getID_DOCENTE());

       //--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID PARTICIPANTE


          Persona participante = docente.getPersona();
        if (participante != null) {
            PersonaDTO participanteDTO = PersonaMapper.DatosAlDTO(participante);
            docenteDTO.setID_PERSONA(participanteDTO);
        }

  //----------------------------------------------------------------Rol_Proyecto Encargado        

         List<CursoArticuladoPDTO> curso_articuladoDTO = docente.getCursoarticulado().stream()
            .map(Curso_ArticuladoPMapper::DatosAlDTO)
            .collect(Collectors.toList());
        docenteDTO.setCurso_articulado(curso_articuladoDTO); 

          //----------------------------------------------------------------Rol_Proyecto Encargado        

         List<ParticipantePDTO> participanteDTO = docente.getParticipante().stream()
            .map(ParticipantePMapper::DatosAlDTO)
            .collect(Collectors.toList());
        docenteDTO.setParticipante(participanteDTO); 
       


        return docenteDTO;
    }



    public static Docente DatosAlaEdentidad(DocenteDTO docenteDTO){

        Docente docente = new Docente();
        docente.setID_DOCENTE(docenteDTO.getID_DOCENTE());

         //--------------------------------------------------------------------- Proyecto  
        PersonaDTO personaDTO = docenteDTO.getID_PERSONA();
        Persona persona = (personaDTO != null) ? PersonaMapper.DatosAlaEdentidad(personaDTO) : null;
        docente.setPersona(persona);
       

        return docente;

    }
    
}
