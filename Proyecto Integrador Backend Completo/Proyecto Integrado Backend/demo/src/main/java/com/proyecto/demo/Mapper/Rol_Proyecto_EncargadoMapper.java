package com.proyecto.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.demo.DTO.Rol_Proyecto_EncargadoDTO;
import com.proyecto.demo.DTOPersonalizados.EncargadoPersonalizadoDTO;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;
import com.proyecto.demo.DTOPersonalizados.Rol_ProyectoPDTO;
import com.proyecto.demo.MappersPersonalizados.EncargadoMapperPersonalizado;
import com.proyecto.demo.MappersPersonalizados.ParticipantePMapper;
import com.proyecto.demo.MappersPersonalizados.Rol_ProyectoPMapper;
import com.proyecto.demo.entity.Encargado;
import com.proyecto.demo.entity.Rol_Proyecto;
import com.proyecto.demo.entity.Rol_Proyecto_Encargado;

public class Rol_Proyecto_EncargadoMapper {
     public static Rol_Proyecto_EncargadoDTO DatosAlDTO(Rol_Proyecto_Encargado rol_Proyecto_Encargado){
       Rol_Proyecto_EncargadoDTO rol_Proyecto_EncargadoDTO = new Rol_Proyecto_EncargadoDTO();

       rol_Proyecto_EncargadoDTO.setID_ROL_PROYECTO_ENCARGADO(rol_Proyecto_Encargado.getID_ROL_PROYECTO_ENCARGADO());
 //--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID PARTICIPANTE


          Rol_Proyecto Var = rol_Proyecto_Encargado.getRol_proyecto();
        if (Var != null) {
            Rol_ProyectoPDTO Var2DTO = Rol_ProyectoPMapper.DatosAlDTO(Var);
            rol_Proyecto_EncargadoDTO.setID_ROL_PROYECTO(Var2DTO);
        }
      
//-----------------------------------------------------ID PARTICIPANTE


          Encargado encargado = rol_Proyecto_Encargado.getEncargado();
        if (encargado != null) {
           EncargadoPersonalizadoDTO encargadoDTO = EncargadoMapperPersonalizado.DatosAlDTO(encargado);
            rol_Proyecto_EncargadoDTO.setID_ENCARGADO(encargadoDTO);
        }


          //----------------------------------------------------------------Listas Que jala  -----------------------------------------------------------------------    


  //----------------------------------------------------------------Rol_Proyecto Encargado        

         List<ParticipantePDTO> participanteDTO = rol_Proyecto_Encargado.getParticipante().stream()
            .map(ParticipantePMapper::DatosAlDTO)
            .collect(Collectors.toList());
        rol_Proyecto_EncargadoDTO.setParticipante(participanteDTO); 
      

        return rol_Proyecto_EncargadoDTO;
    }



    public static Rol_Proyecto_Encargado DatosAlaEdentidad(Rol_Proyecto_EncargadoDTO rol_Proyecto_EncargadoDTO){

        Rol_Proyecto_Encargado rol_Proyecto_Encargado = new Rol_Proyecto_Encargado();
        rol_Proyecto_Encargado.setID_ROL_PROYECTO_ENCARGADO(rol_Proyecto_EncargadoDTO.getID_ROL_PROYECTO_ENCARGADO());


    //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Proyecto  
        Rol_ProyectoPDTO rol_proyectoDTO = rol_Proyecto_EncargadoDTO.getID_ROL_PROYECTO();
        Rol_Proyecto rol_proyecto = (rol_proyectoDTO != null) ? Rol_ProyectoPMapper.DatosAlaEntidad(rol_proyectoDTO) : null;
        rol_Proyecto_Encargado.setRol_proyecto(rol_proyecto);
    //--------------------------------------------------------------------- Proyecto  
        EncargadoPersonalizadoDTO encargadoDTO = rol_Proyecto_EncargadoDTO.getID_ENCARGADO();
        Encargado encargado = (encargadoDTO != null) ? EncargadoMapperPersonalizado.DatosAlaEdentidad(encargadoDTO) : null;
        rol_Proyecto_Encargado.setEncargado(encargado);




        
        return rol_Proyecto_Encargado;

    }
    
}
