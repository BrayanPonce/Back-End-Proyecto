package com.proyecto.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.demo.DTO.CicloDTO;
import com.proyecto.demo.DTOPersonalizados.EscuelaPDTO;
import com.proyecto.demo.DTOPersonalizados.EstudiantePDTO;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;
import com.proyecto.demo.MappersPersonalizados.EscuelaPMapper;
import com.proyecto.demo.MappersPersonalizados.EstudiantePMapper;
import com.proyecto.demo.MappersPersonalizados.ProyectoMapperPersonalizado;
import com.proyecto.demo.entity.Ciclo;
import com.proyecto.demo.entity.Escuela;

public class CicloMapper {



    public static CicloDTO DatosAlDTO(Ciclo ciclo){
       CicloDTO cicloDTO = new CicloDTO();

       cicloDTO.setID_CICLO(ciclo.getID_CICLO());
       cicloDTO.setNOMBRE(ciclo.getNOMBRE()); 

       //--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID Escuela


          Escuela escuela = ciclo.getEscuela();
        if (escuela != null) {
            EscuelaPDTO escuelaDTO = EscuelaPMapper.DatosAlDTO(escuela);
            cicloDTO.setID_ESCUELA(escuelaDTO);
        }


  //----------------------------------------------------------------Listas Que jala  -----------------------------------------------------------------------    


          //----------------------------------------------------------------Estudiante
        List<EstudiantePDTO> estudianteDTO = ciclo.getEstudiante().stream()
            .map(EstudiantePMapper::DatosAlDTO)
            .collect(Collectors.toList());
        cicloDTO.setEstudiante(estudianteDTO); 

                  //----------------------------------------------------------------Proyecto
        List<ProyectoPersonalizadoDTO> proyectoDTO = ciclo.getProyecto().stream()
            .map(ProyectoMapperPersonalizado::DatosAlDTO)
            .collect(Collectors.toList());
        cicloDTO.setProyecto(proyectoDTO); 


        return cicloDTO;
    }



    public static Ciclo DatosAlaEdentidad(CicloDTO cicloDTO){

     Ciclo ciclo = new Ciclo();
        ciclo.setID_CICLO(cicloDTO.getID_CICLO());
        ciclo.setNOMBRE(cicloDTO.getNOMBRE());

     //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Estudiante 
        EscuelaPDTO escuelaDTO = cicloDTO.getID_ESCUELA();
        Escuela escuela = (escuelaDTO != null) ? EscuelaPMapper.DatosAlaEdentidad(escuelaDTO) : null;
        ciclo.setEscuela(escuela);

      

        return ciclo;

    }
    
}
