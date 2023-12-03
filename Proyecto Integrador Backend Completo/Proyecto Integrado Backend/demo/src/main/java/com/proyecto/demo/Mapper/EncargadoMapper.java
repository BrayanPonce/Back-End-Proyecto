package com.proyecto.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.demo.DTO.ActividadesDTO;
import com.proyecto.demo.DTO.EncargadoDTO;
import com.proyecto.demo.DTO.Rol_Proyecto_EncargadoDTO;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;
import com.proyecto.demo.MappersPersonalizados.ParticipantePMapper;
import com.proyecto.demo.entity.Encargado;
import com.proyecto.demo.entity.Participante;

public class EncargadoMapper {


    public static EncargadoDTO DatosAlDTO(Encargado encargado){
       EncargadoDTO encargadoDTO = new EncargadoDTO();

       encargadoDTO.setID_ENCARGADO(encargado.getID_ENCARGADO());
       encargadoDTO.setNOMBRE(encargado.getNOMBRE()); 
       encargadoDTO.setROL(encargado.getROL()); 

       
//--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID PARTICIPANTE


          Participante participante = encargado.getParticipante();
        if (participante != null) {
            ParticipantePDTO participanteDTO = ParticipantePMapper.DatosAlDTO(participante);
            encargadoDTO.setID_PARTICIPANTE(participanteDTO);
        }



  //----------------------------------------------------------------Listas Que jala  -----------------------------------------------------------------------    


  //----------------------------------------------------------------Rol_Proyecto Encargado        

         List<Rol_Proyecto_EncargadoDTO> rol_Proyecto_EncargadoDTO = encargado.getRol_proyecto_encargado().stream()
            .map(Rol_Proyecto_EncargadoMapper::DatosAlDTO)
            .collect(Collectors.toList());
        encargadoDTO.setRol_proyecto_encargado(rol_Proyecto_EncargadoDTO); 

  //----------------------------------------------------------------Actividades
        List<ActividadesDTO> actividadesDTO = encargado.getActividad().stream()
            .map(ActividadesMapper::DatosAlDTO)
            .collect(Collectors.toList());
        encargadoDTO.setActividadd(actividadesDTO); 



        return encargadoDTO;
    }



    public static Encargado DatosAlaEdentidad(EncargadoDTO encargadoDTO){

        Encargado encargado = new Encargado();
        encargado.setID_ENCARGADO(encargadoDTO.getID_ENCARGADO());
        encargado.setNOMBRE(encargadoDTO.getNOMBRE());
         encargado.setROL(encargadoDTO.getROL());


            //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Proyecto  
        ParticipantePDTO participanteDTO = encargadoDTO.getID_PARTICIPANTE();
        Participante participante = (participanteDTO != null) ? ParticipantePMapper.DatosAlaEdentidad(participanteDTO) : null;
        encargado.setParticipante(participante);

         

        return encargado;

    }








    
}
