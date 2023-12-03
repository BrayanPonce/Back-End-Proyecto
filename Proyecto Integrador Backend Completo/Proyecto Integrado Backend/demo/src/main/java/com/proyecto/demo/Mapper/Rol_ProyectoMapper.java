package com.proyecto.demo.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.demo.DTO.Rol_NegocioDTO;
import com.proyecto.demo.DTO.Rol_ProyectoDTO;
import com.proyecto.demo.DTO.Rol_Proyecto_EncargadoDTO;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;
import com.proyecto.demo.MappersPersonalizados.ProyectoMapperPersonalizado;
import com.proyecto.demo.entity.Proyecto;
import com.proyecto.demo.entity.Rol_Negocio;
import com.proyecto.demo.entity.Rol_Proyecto;

public class Rol_ProyectoMapper {

    public static Rol_ProyectoDTO DatosAlDTO(Rol_Proyecto rol_proyecto) {
        Rol_ProyectoDTO rol_proyectoDTO = new Rol_ProyectoDTO();
        rol_proyectoDTO.setID_ROL_PROYECTO(rol_proyecto.getID_ROL_PROYECTO());
        rol_proyectoDTO.setHORA(rol_proyecto.getHORA());
        rol_proyectoDTO.setDESCRIPCION(rol_proyecto.getDESCRIPCION());

//--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID PROYECTO


          Proyecto proyecto = rol_proyecto.getProyecto();
        if (proyecto != null) {
            ProyectoPersonalizadoDTO proyectoDTO = ProyectoMapperPersonalizado.DatosAlDTO(proyecto);
            rol_proyectoDTO.setID_PROYECTO(proyectoDTO);
        }


//-----------------------------------------------------ID ROL_NEGOCIO

         Rol_Negocio rol_negocio = rol_proyecto.getRol_negocio();
             if (rol_negocio != null) {
        Rol_NegocioDTO rol_negocioDTO = Rol_NegocioMapper.DatosAlDTO(rol_negocio);
             rol_proyectoDTO.setID_ROL_NEGOCIO(rol_negocioDTO);
}




//--------------------------------------------------------------------- Termina ids que jala------------------------------------------------------------------------



  //----------------------------------------------------------------Listas Que jala  -----------------------------------------------------------------------    


  //----------------------------------------------------------------Rol_Proyecto Encargado

   List<Rol_Proyecto_EncargadoDTO> rol_Proyecto_EncargadoDTO = rol_proyecto.getRol_proyecto_encargado().stream()
            .map(Rol_Proyecto_EncargadoMapper::DatosAlDTO)
            .collect(Collectors.toList());
        rol_proyectoDTO.setRol_proyecto_encargado(rol_Proyecto_EncargadoDTO); 

 //----------------------------------------------------------------Termina Lista que Jala  -----------------------------------------------------------------------    



        return rol_proyectoDTO;

    }

    public static Rol_Proyecto DatosAlaEntidad(Rol_ProyectoDTO rol_proyectoDTO) {
        Rol_Proyecto rol_proyecto = new Rol_Proyecto();
        rol_proyecto.setID_ROL_PROYECTO(rol_proyectoDTO.getID_ROL_PROYECTO());
        rol_proyecto.setHORA(rol_proyectoDTO.getHORA());
        rol_proyecto.setDESCRIPCION(rol_proyectoDTO.getDESCRIPCION());

    //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Proyecto  
        ProyectoPersonalizadoDTO proyectoPersonalizadoDTO = rol_proyectoDTO.getID_PROYECTO();
        Proyecto proyecto = (proyectoPersonalizadoDTO != null) ? ProyectoMapperPersonalizado.DatosAlaEdentidad(proyectoPersonalizadoDTO) : null;
        rol_proyecto.setProyecto(proyecto);


    //--------------------------------------------------------------------- ROL_NEGOCIO 
     Rol_NegocioDTO rol_NegocioDTO = rol_proyectoDTO.getID_ROL_NEGOCIO();
        Rol_Negocio rol_negocio = (rol_NegocioDTO != null) ? Rol_NegocioMapper.DatosAlaEdentidad(rol_NegocioDTO) : null;
        rol_proyecto.setRol_negocio(rol_negocio);

        return rol_proyecto;
    }


}
