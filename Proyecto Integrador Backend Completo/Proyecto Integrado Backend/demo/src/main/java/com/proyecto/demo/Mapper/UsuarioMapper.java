package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.PersonaDTO;
import com.proyecto.demo.DTO.UsuarioDTO;
import com.proyecto.demo.entity.Persona;
import com.proyecto.demo.entity.Usuario;

public class UsuarioMapper {


       public static UsuarioDTO DatosAlDTO(Usuario usuario){
       UsuarioDTO usuarioDTO = new UsuarioDTO();

       usuarioDTO.setID_USUARIO(usuario.getID_USUARIO());
       usuarioDTO.setUSERNAME(usuario.getUSERNAME()); 
       usuarioDTO.setPASSWORD(usuario.getPASSWORD()); 

       //--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID PARTICIPANTE


          Persona participante = usuario.getPersonaR();
        if (participante != null) {
            PersonaDTO participanteDTO = PersonaMapper.DatosAlDTO(participante);
            usuarioDTO.setID_PERSONA(participanteDTO);
        }




        return usuarioDTO;
    }



    public static Usuario DatosAlaEdentidad(UsuarioDTO usuarioDTO){

        Usuario usuario = new Usuario();
        usuario.setID_USUARIO(usuarioDTO.getID_USUARIO());
        usuario.setUSERNAME(usuarioDTO.getUSERNAME());
        usuario.setPASSWORD(usuarioDTO.getPASSWORD());

    //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Proyecto  
        PersonaDTO personaDTO = usuarioDTO.getID_PERSONA();
        Persona persona = (personaDTO != null) ? PersonaMapper.DatosAlaEdentidad(personaDTO) : null;
        usuario.setPersonaR(persona);

       




        return usuario;
    }



    
}
