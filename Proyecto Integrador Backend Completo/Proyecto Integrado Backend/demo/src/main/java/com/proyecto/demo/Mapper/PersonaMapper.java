package com.proyecto.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.demo.DTO.PersonaDTO;
import com.proyecto.demo.DTO.Rol_SistemaDTO;
import com.proyecto.demo.DTOPersonalizados.CursoArticuladoPDTO;
import com.proyecto.demo.DTOPersonalizados.DocentePDTO;
import com.proyecto.demo.DTOPersonalizados.EstudiantePDTO;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;
import com.proyecto.demo.MappersPersonalizados.Curso_ArticuladoPMapper;
import com.proyecto.demo.MappersPersonalizados.DocentePMapper;
import com.proyecto.demo.MappersPersonalizados.EstudiantePMapper;
import com.proyecto.demo.MappersPersonalizados.ParticipantePMapper;
import com.proyecto.demo.entity.Persona;
import com.proyecto.demo.entity.Rol_Sistema;

public class PersonaMapper {
    
    public static PersonaDTO DatosAlDTO(Persona persona){
       PersonaDTO personaDTO = new PersonaDTO();

       personaDTO.setID_PERSONA(persona.getID_PERSONA());
       personaDTO.setNOMBRE(persona.getNOMBRE()); 
       personaDTO.setDNI(persona.getDNI()); 

       
//--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID PARTICIPANTE


          Rol_Sistema rol_Sistema = persona.getRol_sistema();
        if (rol_Sistema != null) {
            Rol_SistemaDTO rol_SistemaDTO = Rol_SistemaMapper.DatosAlDTO(rol_Sistema);
            personaDTO.setID_ROL_SISTEMA(rol_SistemaDTO);
        }

  //----------------------------------------------------------------Actividades
        List<EstudiantePDTO> estudiantesDTO = persona.getEstudiantes().stream()
            .map(EstudiantePMapper::DatosAlDTO)
            .collect(Collectors.toList());
        personaDTO.setEstudiantes(estudiantesDTO); 


 //----------------------------------------------------------------Actividades
        List<CursoArticuladoPDTO> cursoArticuladoDTO = persona.getCursoarticulado().stream()
            .map(Curso_ArticuladoPMapper::DatosAlDTO)
            .collect(Collectors.toList());
        personaDTO.setCursoarticulado(cursoArticuladoDTO); 

  //----------------------------------------------------------------Actividades
        List<ParticipantePDTO> participanteDTO = persona.getParticipante().stream()
            .map(ParticipantePMapper::DatosAlDTO)
            .collect(Collectors.toList());
        personaDTO.setParticipante(participanteDTO); 
  //----------------------------------------------------------------Actividades
        List<DocentePDTO> docenteDTO = persona.getDocente().stream()
            .map(DocentePMapper::DatosAlDTO)
            .collect(Collectors.toList());
        personaDTO.setDocente(docenteDTO); 

        return personaDTO;
    }



    public static Persona DatosAlaEdentidad(PersonaDTO personaDTO){

        Persona persona = new Persona();
        persona.setID_PERSONA(personaDTO.getID_PERSONA());
        persona.setNOMBRE(personaDTO.getNOMBRE());
        persona.setDNI(personaDTO.getDNI());

    //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Proyecto  
        Rol_SistemaDTO rol_SistemaDTO = personaDTO.getID_ROL_SISTEMA();
        Rol_Sistema rol_Sistema = (rol_SistemaDTO != null) ? Rol_SistemaMapper.DatosAlaEdentidad(rol_SistemaDTO) : null;
        persona.setRol_sistema(rol_Sistema);

        return persona;

    }
    
}
