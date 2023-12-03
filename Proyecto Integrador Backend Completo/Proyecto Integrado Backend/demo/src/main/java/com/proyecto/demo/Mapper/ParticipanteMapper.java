package com.proyecto.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.demo.DTO.Actividad_ParticipanteDTO;
import com.proyecto.demo.DTO.DocenteDTO;
import com.proyecto.demo.DTO.EncargadoDTO;
import com.proyecto.demo.DTO.EstudianteDTO;
import com.proyecto.demo.DTO.ParticipanteDTO;
import com.proyecto.demo.DTO.PersonaDTO;
import com.proyecto.demo.DTO.Rol_Proyecto_EncargadoDTO;
import com.proyecto.demo.DTO.Rol_SistemaDTO;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;
import com.proyecto.demo.MappersPersonalizados.ProyectoMapperPersonalizado;
import com.proyecto.demo.entity.Docente;
import com.proyecto.demo.entity.Estudiante;
import com.proyecto.demo.entity.Participante;
import com.proyecto.demo.entity.Persona;
import com.proyecto.demo.entity.Proyecto;
import com.proyecto.demo.entity.Rol_Proyecto_Encargado;
import com.proyecto.demo.entity.Rol_Sistema;

public class ParticipanteMapper {

  public static ParticipanteDTO DatosAlDTO(Participante participante) {
    ParticipanteDTO participanteDTO = new ParticipanteDTO();
    participanteDTO.setID_PARTICIPANTE(participante.getID_PARTICIPANTE());
    participanteDTO.setHoras(participante.getHoras());

        //--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID Rol_Sistema


          Rol_Sistema rol_Sistema = participante.getRol_sistema();
        if (rol_Sistema != null) {
            Rol_SistemaDTO rol_SistemaDTO = Rol_SistemaMapper.DatosAlDTO(rol_Sistema);
            participanteDTO.setID_ROL_SISTEMA(rol_SistemaDTO);
        }


//-----------------------------------------------------ID Docente


          Docente docente = participante.getDocente();
        if (docente != null) {
            DocenteDTO docenteDTO = DocenteMapper.DatosAlDTO(docente);
            participanteDTO.setID_DOCENTE(docenteDTO);
        }

//-----------------------------------------------------ID Estudiante


          Estudiante estudiante = participante.getEstudiante();
        if (estudiante != null) {
            EstudianteDTO estudianteDTO = EstudianteMapper.DatosAlDTO(estudiante);
            participanteDTO.setID_ESTUDIANTE(estudianteDTO);
        }


//-----------------------------------------------------ID Persona


          Persona persona = participante.getPersona();
        if (persona != null) {
            PersonaDTO personaDTO = PersonaMapper.DatosAlDTO(persona);
            participanteDTO.setID_PERSONA(personaDTO);
        }


//-----------------------------------------------------ID ROL_PROYECTO_ENCARGADO


          Rol_Proyecto_Encargado rol_proyecto_encargado = participante.getRol_proyecto_encargado();
        if (rol_proyecto_encargado != null) {
            Rol_Proyecto_EncargadoDTO rol_proyecto_encargadoDTO = Rol_Proyecto_EncargadoMapper.DatosAlDTO(rol_proyecto_encargado);
            participanteDTO.setID_ROL_PROYECTO_ENCARGADO(rol_proyecto_encargadoDTO);}


//-----------------------------------------------------ID Proyecto


          Proyecto proyecto = participante.getProyecto();
        if (proyecto != null) {
            ProyectoPersonalizadoDTO proyectoDTO = ProyectoMapperPersonalizado.DatosAlDTO(proyecto);
            participanteDTO.setID_PROYECTO(proyectoDTO);
        }

         //----------------------------------------------------------------Listas Que jala  -----------------------------------------------------------------------    


  //----------------------------------------------------------------Encargado    

         List<EncargadoDTO> encargadoDTO = participante.getEncargado().stream()
            .map(EncargadoMapper::DatosAlDTO)
            .collect(Collectors.toList());
        participanteDTO.setEncargado(encargadoDTO);


  //----------------------------------------------------------------Encargado    

         List<Actividad_ParticipanteDTO> actividad_participanteDTO = participante.getActividad_Participante().stream()
            .map(Actividad_ParticipanteMapper::DatosAlDTO)
            .collect(Collectors.toList());
        participanteDTO.setActividad_Participante(actividad_participanteDTO);

     return participanteDTO;

  }








    public static Participante DatosAlaEntidad(ParticipanteDTO participanteDTO) {
      Participante participante = new Participante();
      participante.setID_PARTICIPANTE(participanteDTO.getID_PARTICIPANTE());
      participante.setHoras(participanteDTO.getHoras());


    //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- ROL_SISTEMA
        Rol_SistemaDTO rol_SistemaDTO = participanteDTO.getID_ROL_SISTEMA();
        Rol_Sistema rol_Sistema = (rol_SistemaDTO != null) ? Rol_SistemaMapper.DatosAlaEdentidad(rol_SistemaDTO) : null;
        participante.setRol_sistema(rol_Sistema);



        
        
        
        //--------------------------------------------------------------------- Estudiante
        EstudianteDTO estudianteDTO = participanteDTO.getID_ESTUDIANTE();
        Estudiante estudiante = (estudianteDTO != null) ? EstudianteMapper.DatosAlaEdentidad(estudianteDTO) : null;
        participante.setEstudiante(estudiante);
        
        
        //--------------------------------------------------------------------- Persona
        PersonaDTO personaDTO = participanteDTO.getID_PERSONA();
        Persona persona = (personaDTO != null) ? PersonaMapper.DatosAlaEdentidad(personaDTO) : null;
        participante.setPersona(persona);
        
        //--------------------------------------------------------------------- Docente
             DocenteDTO docenteDTO = participanteDTO.getID_DOCENTE();
             Docente docente = (docenteDTO != null) ? DocenteMapper.DatosAlaEdentidad(docenteDTO) : null;
             participante.setDocente(docente);
        

      Rol_Proyecto_EncargadoDTO rol_Proyecto_EncargadoDTO = participanteDTO.getID_ROL_PROYECTO_ENCARGADO();
      Rol_Proyecto_Encargado rol_Proyecto_Encargado = (rol_Proyecto_EncargadoDTO != null) ? Rol_Proyecto_EncargadoMapper.DatosAlaEdentidad(rol_Proyecto_EncargadoDTO) : null;
      participante.setRol_proyecto_encargado(rol_Proyecto_Encargado);




   //--------------------------------------------------------------------- Proyecto
        ProyectoPersonalizadoDTO proyectoDTO = participanteDTO.getID_PROYECTO();
        Proyecto proyecto = (proyectoDTO != null) ? ProyectoMapperPersonalizado.DatosAlaEdentidad(proyectoDTO) : null;
        participante.setProyecto(proyecto);

      return participante;
    }

  

}
