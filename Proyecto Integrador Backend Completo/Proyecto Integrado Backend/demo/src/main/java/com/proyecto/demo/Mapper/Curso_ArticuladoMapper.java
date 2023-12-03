package com.proyecto.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.demo.DTO.CursoArticuladoDTO;
import com.proyecto.demo.DTO.DocenteDTO;
import com.proyecto.demo.DTO.PersonaDTO;
import com.proyecto.demo.DTOPersonalizados.EscuelaPDTO;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;
import com.proyecto.demo.MappersPersonalizados.EscuelaPMapper;
import com.proyecto.demo.MappersPersonalizados.ProyectoMapperPersonalizado;
import com.proyecto.demo.entity.CursoArticulado;
import com.proyecto.demo.entity.Docente;
import com.proyecto.demo.entity.Escuela;
import com.proyecto.demo.entity.Persona;

public class Curso_ArticuladoMapper {

    
    public static CursoArticuladoDTO DatosAlDTO(CursoArticulado cursoarticulado){

        CursoArticuladoDTO cursoarticuladoDTO = new CursoArticuladoDTO();

        cursoarticuladoDTO.setID_CURSO_ARTICULADO(cursoarticulado.getID_CURSO_ARTICULADO());
        cursoarticuladoDTO.setNOMBRE(cursoarticulado.getNOMBRE());
               
//--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID Escuela


          Escuela Var = cursoarticulado.getEscuela();
        if (Var != null) {
            EscuelaPDTO VarDTO = EscuelaPMapper.DatosAlDTO(Var);
            cursoarticuladoDTO.setID_ESCUELA(VarDTO);
        }

         
//-----------------------------------------------------ID Persona


          Persona Var2 = cursoarticulado.getPersona();
        if (Var2 != null) {
            PersonaDTO VarDTO = PersonaMapper.DatosAlDTO(Var2);
            cursoarticuladoDTO.setID_PERSONA(VarDTO);
        }

        //-----------------------------------------------------ID Docente


          Docente Var3 = cursoarticulado.getDocente();
        if (Var3 != null) {
            DocenteDTO VarDTO = DocenteMapper.DatosAlDTO(Var3);
            cursoarticuladoDTO.setID_DOCENTE(VarDTO);

        }

          //----------------------------------------------------------------Listas Que jala  -----------------------------------------------------------------------    


        List<ProyectoPersonalizadoDTO> proyectoDTO = cursoarticulado.getProyecto().stream()
            .map(ProyectoMapperPersonalizado::DatosAlDTO)
            .collect(Collectors.toList());
        cursoarticuladoDTO.setProyecto(proyectoDTO); 


        return cursoarticuladoDTO;
    }

    public static CursoArticulado DatosAlaEdentidad(CursoArticuladoDTO cursoarticuladoDTO){

        CursoArticulado cursoarticulado = new CursoArticulado();

    cursoarticulado.setID_CURSO_ARTICULADO(cursoarticuladoDTO.getID_CURSO_ARTICULADO());
    cursoarticulado.setNOMBRE(cursoarticuladoDTO.getNOMBRE());


//-----------------------------------------------------ID Escuela

    EscuelaPDTO VarDTO = cursoarticuladoDTO.getID_ESCUELA();
    Escuela VarF = (VarDTO != null) ? EscuelaPMapper.DatosAlaEdentidad(VarDTO) : null;
    cursoarticulado.setEscuela(VarF);
    
//-----------------------------------------------------ID Docente

 DocenteDTO Var2DTO = cursoarticuladoDTO.getID_DOCENTE();
    Docente Var2F = (Var2DTO != null) ? DocenteMapper.DatosAlaEdentidad(Var2DTO) : null;
    cursoarticulado.setDocente(Var2F);

//-----------------------------------------------------ID Persona


PersonaDTO Var3DTO = cursoarticuladoDTO.getID_PERSONA();
    Persona Var3F = (Var3DTO != null) ? PersonaMapper.DatosAlaEdentidad(Var3DTO) : null;
    cursoarticulado.setPersona(Var3F);
        return cursoarticulado;

    }
    
}
