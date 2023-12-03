package com.proyecto.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.demo.DTO.CicloDTO;
import com.proyecto.demo.DTO.EstudianteDTO;
import com.proyecto.demo.DTO.Grupo_UnivDTO;
import com.proyecto.demo.DTO.PersonaDTO;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;
import com.proyecto.demo.MappersPersonalizados.ParticipantePMapper;
import com.proyecto.demo.entity.Ciclo;
import com.proyecto.demo.entity.Estudiante;
import com.proyecto.demo.entity.Grupo_Univ;
import com.proyecto.demo.entity.Persona;

public class EstudianteMapper {

    
    public static EstudianteDTO DatosAlDTO(Estudiante estudiante){
       EstudianteDTO estudianteDTO = new EstudianteDTO();

       estudianteDTO.setID_ESTUDIANTE(estudiante.getID_ESTUDIANTE());
       estudianteDTO.setCODIGO(estudiante.getCODIGO());
        estudianteDTO.setHORAS_TOTALES(estudiante.getHORAS_TOTALES());

        //--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID Ciclo


          Ciclo ciclo = estudiante.getCiclo();
        if (ciclo != null) {
            CicloDTO cicloDTO = CicloMapper.DatosAlDTO(ciclo);
            estudianteDTO.setID_CICLO(cicloDTO);
        }
 
//-----------------------------------------------------ID Grupo_Univ


          Grupo_Univ grupo_Univ = estudiante.getGrupo_univ();
        if (grupo_Univ != null) {
            Grupo_UnivDTO grupo_UnivDTO = Grupo_UnivMapper.DatosAlDTO(grupo_Univ);
            estudianteDTO.setID_GRUPO_UNIV(grupo_UnivDTO);
        }

//-----------------------------------------------------ID Persona


          Persona persona = estudiante.getPersona();
        if (persona != null) {
            PersonaDTO personaDTO = PersonaMapper.DatosAlDTO(persona);
            estudianteDTO.setID_PERSONA(personaDTO);
        }

        
  //----------------------------------------------------------------Listas Que jala  -----------------------------------------------------------------------    


  //----------------------------------------------------------------Participante        

         List<ParticipantePDTO> participanteDTO = estudiante.getParticipante().stream()
            .map(ParticipantePMapper::DatosAlDTO)
            .collect(Collectors.toList());
        estudianteDTO.setParticipante(participanteDTO); 
 


        return estudianteDTO;
    }



    public static Estudiante DatosAlaEdentidad(EstudianteDTO estudianteDTO){

        Estudiante estudiante = new Estudiante();
        estudiante.setID_ESTUDIANTE(estudianteDTO.getID_ESTUDIANTE());
        estudiante.setCODIGO(estudianteDTO.getCODIGO());
        estudiante.setHORAS_TOTALES(estudianteDTO.getHORAS_TOTALES());

        
    //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Ciclo
    CicloDTO cicloDTO = estudianteDTO.getID_CICLO();
    Ciclo ciclo = (cicloDTO != null) ? CicloMapper.DatosAlaEdentidad(cicloDTO) : null;
    estudiante.setCiclo(ciclo);

    //--------------------------------------------------------------------- Grupo_Univ
    Grupo_UnivDTO grupo_UnivDTO = estudianteDTO.getID_GRUPO_UNIV();
    Grupo_Univ grupo_Univ = (grupo_UnivDTO != null) ? Grupo_UnivMapper.DatosAlaEdentidad(grupo_UnivDTO) : null;
    estudiante.setGrupo_univ(grupo_Univ);


         //--------------------------------------------------------------------- Persona
    PersonaDTO personaDTO = estudianteDTO.getID_PERSONA();
    Persona persona = (personaDTO != null) ? PersonaMapper.DatosAlaEdentidad(personaDTO) : null;
    estudiante.setPersona(persona);





        return estudiante;

    }
    


    
}
