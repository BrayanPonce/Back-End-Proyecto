package com.proyecto.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.demo.DTO.CicloDTO;
import com.proyecto.demo.DTO.CursoArticuladoDTO;
import com.proyecto.demo.DTO.EscuelaDTO;
import com.proyecto.demo.DTO.FacultadDTO;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;
import com.proyecto.demo.MappersPersonalizados.ProyectoMapperPersonalizado;
import com.proyecto.demo.entity.Escuela;
import com.proyecto.demo.entity.Facultad;

public class EscuelaMapper {



    public static EscuelaDTO DatosAlDTO(Escuela escuela){

        EscuelaDTO escuelaDTO = new EscuelaDTO();

        escuelaDTO.setID_ESCUELA(escuela.getID_ESCUELA());
        // escuelaDTO.setID_FACULTAD(escuela.getID_FACULTAD());
        escuelaDTO.setNOMBRE(escuela.getNOMBRE());

        //--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID Facultad


          Facultad facultad = escuela.getFACULTAD();
        if (facultad != null) {
            FacultadDTO facultadDTO = FacultadMapper.DatosAlDTO(facultad);
            escuelaDTO.setID_FACULTAD(facultadDTO);
        }


         //----------------------------------------------------------------Listas Que jala  -----------------------------------------------------------------------    


  //----------------------------------------------------------------Proyecto     

         List<ProyectoPersonalizadoDTO> proyectoPersonalizadoDTO = escuela.getProyecto().stream()
            .map(ProyectoMapperPersonalizado::DatosAlDTO)
            .collect(Collectors.toList());
        escuelaDTO.setPROYECTO(proyectoPersonalizadoDTO); 

 //----------------------------------------------------------------Ciclo   

         List<CicloDTO> cicloDTO = escuela.getCiclo().stream()
            .map(CicloMapper::DatosAlDTO)
            .collect(Collectors.toList());
        escuelaDTO.setCiclo(cicloDTO); 

//----------------------------------------------------------------Curso Articulo   

         List<CursoArticuladoDTO> cursoArticuladoDTO = escuela.getCursoarticulado().stream()
            .map(Curso_ArticuladoMapper::DatosAlDTO)
            .collect(Collectors.toList());
        escuelaDTO.setCursoArticulado(cursoArticuladoDTO); 





        return escuelaDTO;
    }

    public static Escuela DatosAlaEdentidad(EscuelaDTO escuelaDTO){

        Escuela escuela = new Escuela();

    escuela.setID_ESCUELA(escuelaDTO.getID_ESCUELA());
    // escuela.setID_FACULTAD(escuelaDTO.getID_FACULTAD());
        escuela.setNOMBRE(escuelaDTO.getNOMBRE());


     //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Proyecto  
        FacultadDTO facultadDTO = escuelaDTO.getID_FACULTAD();
        Facultad facultad = (facultadDTO != null) ? FacultadMapper.DatosAlaEdentidad(facultadDTO) : null;
        escuela.setFACULTAD(facultad);


        return escuela;

    }
    
}
