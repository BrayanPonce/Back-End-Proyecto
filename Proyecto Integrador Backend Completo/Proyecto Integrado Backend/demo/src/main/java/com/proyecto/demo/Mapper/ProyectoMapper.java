package com.proyecto.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.demo.DTO.ActividadesDTO;
import com.proyecto.demo.DTO.CicloDTO;
import com.proyecto.demo.DTO.CursoArticuladoDTO;
import com.proyecto.demo.DTO.EscuelaDTO;
import com.proyecto.demo.DTO.EstadoDTO;
import com.proyecto.demo.DTO.ProyectoDTO;
import com.proyecto.demo.DTO.RecursoDTO;
import com.proyecto.demo.DTO.Rol_ProyectoDTO;
import com.proyecto.demo.DTO.SemestreDTO;
import com.proyecto.demo.DTO.Tipo_De_ConvenioDTO;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;
import com.proyecto.demo.MappersPersonalizados.ParticipantePMapper;
import com.proyecto.demo.entity.Ciclo;
import com.proyecto.demo.entity.CursoArticulado;
import com.proyecto.demo.entity.Escuela;
import com.proyecto.demo.entity.Estado;
import com.proyecto.demo.entity.Proyecto;
import com.proyecto.demo.entity.Semestre;
import com.proyecto.demo.entity.Tipo_De_Convenio;

public class ProyectoMapper {
    public static ProyectoDTO DatosAlDTO(Proyecto proyecto) {
        ProyectoDTO proyectoDTO = new ProyectoDTO();
        proyectoDTO.setID_PROYECTO(proyecto.getID_PROYECTO());
        proyectoDTO.setNOMBRE(proyecto.getNOMBRE());
        proyectoDTO.setCODIGO(proyecto.getCODIGO());
        proyectoDTO.setCOORDINADOR(proyecto.getCOORDINADOR());
        proyectoDTO.setFECHA_INICIO(proyecto.getFECHA_INICIO());
        proyectoDTO.setFECHA_FIN(proyecto.getFECHA_FIN());
        proyectoDTO.setLUGAR(proyecto.getLUGAR());
        proyectoDTO.setOBJETIVOS(proyecto.getOBJETIVOS());
        proyectoDTO.setDESCRIPCION(proyecto.getDESCRIPCION());
        proyectoDTO.setPRESUPUESTO(proyecto.getPRESUPUESTO());
        proyectoDTO.setINFORME_FINAL(proyecto.getINFORME_FINAL());
  
        
//--------------------------------------------------------------------- IDs que Jala------------------------------------------------------------------------
      

//--------------------------------------------------------------------- Semestre
        Semestre semestre = proyecto.getSemestre();
        if (semestre != null) {
            SemestreDTO semestreDTO = SemestreMapper.SemestreADTO(semestre);
            proyectoDTO.setID_SEMESTRE(semestreDTO);
        }
//--------------------------------------------------------------------- Escuela
         Escuela escuela = proyecto.getEscuela();
        if (escuela != null) {
            EscuelaDTO escuelaDTO = EscuelaMapper.DatosAlDTO(escuela);
            proyectoDTO.setID_ESCUELA(escuelaDTO);
        }
//--------------------------------------------------------------------- Estado
          Estado estado = proyecto.getEstado();
        if (estado != null) {
            EstadoDTO estadoDTO = EstadoMapper.DatosAlDTO(estado);
            proyectoDTO.setID_ESTADO(estadoDTO);
        }
//--------------------------------------------------------------------- Tipo de Convenio
          Tipo_De_Convenio tipo_De_Convenio = proyecto.getTipo_de_convenio();
        if (estado != null) {
            Tipo_De_ConvenioDTO tipo_De_ConvenioDTO = Tipo_De_ConvenioMapper.DatosAlDTO(tipo_De_Convenio);
            proyectoDTO.setID_TIPO_DE_CONVENIO(tipo_De_ConvenioDTO);
        }
//--------------------------------------------------------------------- Curso Articulado
          CursoArticulado cursoArticulado = proyecto.getCursoarticulado();
        if (cursoArticulado != null) {
            CursoArticuladoDTO cursoArticuladoDTO = Curso_ArticuladoMapper.DatosAlDTO(cursoArticulado);
            proyectoDTO.setID_CURSO_ARTICULADO(cursoArticuladoDTO);
        }
//--------------------------------------------------------------------- Ciclo
          Ciclo ciclo = proyecto.getCiclo();
        if (ciclo != null) {
            CicloDTO cicloDTO = CicloMapper.DatosAlDTO(ciclo);
            proyectoDTO.setID_CICLO(cicloDTO);
        }
//--------------------------------------------------------------------- Termina ids que jala------------------------------------------------------------------------



  //----------------------------------------------------------------Listas Que jala  -----------------------------------------------------------------------    


//----------------------------------------------------------------Actividad  

        List<ActividadesDTO> actividadesDTO = proyecto.getActividad().stream()
            .map(ActividadesMapper::DatosAlDTO)
            .collect(Collectors.toList());
        proyectoDTO.setActividades(actividadesDTO);

//----------------------------------------------------------------Recurso

        List<RecursoDTO> recursoDTO = proyecto.getRecurso().stream()
            .map(RecursoMapper::entidadADTO)
            .collect(Collectors.toList());
            proyectoDTO.setRecurso(recursoDTO);

//----------------------------------------------------------------Rol_Proyecto

         List<Rol_ProyectoDTO> rol_proyectoDTO = proyecto.getRol_proyecto().stream()
            .map(Rol_ProyectoMapper::DatosAlDTO)
            .collect(Collectors.toList());
            proyectoDTO.setRol_proyecto(rol_proyectoDTO);




            
            //----------------------------------------------------------------Participante
            
            List<ParticipantePDTO> participanteDTO = proyecto.getParticipante().stream()
            .map(ParticipantePMapper::DatosAlDTO)
            .collect(Collectors.toList());
            proyectoDTO.setParticipante(participanteDTO);
            
            
 //----------------------------------------------------------------Termina Lista que Jala  -----------------------------------------------------------------------    

        return proyectoDTO;
    }

    public static Proyecto DatosAlaEdentidad(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = new Proyecto();
        proyecto.setID_PROYECTO(proyectoDTO.getID_PROYECTO());
        proyecto.setNOMBRE(proyectoDTO.getNOMBRE());
        proyecto.setCODIGO(proyectoDTO.getCODIGO());
        proyecto.setCOORDINADOR(proyectoDTO.getCOORDINADOR());
        proyecto.setFECHA_INICIO(proyectoDTO.getFECHA_INICIO());
        proyecto.setFECHA_FIN(proyectoDTO.getFECHA_FIN());
        proyecto.setLUGAR(proyectoDTO.getLUGAR());
        proyecto.setOBJETIVOS(proyectoDTO.getOBJETIVOS());
        proyecto.setDESCRIPCION(proyectoDTO.getOBJETIVOS());
        proyecto.setPRESUPUESTO(proyectoDTO.getPRESUPUESTO());
        proyecto.setINFORME_FINAL(proyectoDTO.getINFORME_FINAL());
    

    //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio


//--------------------------------------------------------------------- Semestre    

        SemestreDTO semestreDTO = proyectoDTO.getID_SEMESTRE();
        Semestre semestre = (semestreDTO != null) ? SemestreMapper.DTOASemestre(semestreDTO) : null;
        proyecto.setSemestre(semestre);

//--------------------------------------------------------------------- Escuela

        EscuelaDTO escuelaDTO = proyectoDTO.getID_ESCUELA();
        Escuela escuela = (escuelaDTO != null) ? EscuelaMapper.DatosAlaEdentidad(escuelaDTO) : null;
        proyecto.setEscuela(escuela);

//--------------------------------------------------------------------- Estado
        EstadoDTO estadoDTO = proyectoDTO.getID_ESTADO();
        Estado estado = (estadoDTO != null) ? EstadoMapper.DatosAlaEdentidad(estadoDTO) : null;
        proyecto.setEstado(estado);

//--------------------------------------------------------------------- Tipo de Convenio
        Tipo_De_ConvenioDTO tipo_de_convenioDTO = proyectoDTO.getID_TIPO_DE_CONVENIO();
        Tipo_De_Convenio tipo_de_convenio = (tipo_de_convenioDTO != null) ? Tipo_De_ConvenioMapper.DatosAlaEdentidad(tipo_de_convenioDTO) : null;
        proyecto.setTipo_de_convenio(tipo_de_convenio);

//--------------------------------------------------------------------- Curso Articulado
        CursoArticuladoDTO cursoArticuladoDTO = proyectoDTO.getID_CURSO_ARTICULADO();
        CursoArticulado cursoArticulado = (cursoArticuladoDTO != null) ? Curso_ArticuladoMapper.DatosAlaEdentidad(cursoArticuladoDTO) : null;
        proyecto.setCursoarticulado(cursoArticulado);

//--------------------------------------------------------------------- Ciclo
        CicloDTO cicloDTO = proyectoDTO.getID_CICLO();
        Ciclo ciclo = (cicloDTO != null) ? CicloMapper.DatosAlaEdentidad(cicloDTO) : null;
        proyecto.setCiclo(ciclo);
       
        return proyecto;
    }
    
}