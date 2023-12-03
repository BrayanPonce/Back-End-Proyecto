package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.AccesoDTO;
import com.proyecto.demo.DTO.UsuarioDTO;
import com.proyecto.demo.DTO.Usuario_AccesosDTO;
import com.proyecto.demo.entity.Acceso;
import com.proyecto.demo.entity.Usuario;
import com.proyecto.demo.entity.Usuario_Accesos;

public class Usuario_AccesosMapper {

    
    public static Usuario_AccesosDTO DatosAlDTO(Usuario_Accesos usuario_accesos){
       Usuario_AccesosDTO usuario_accesosDTO = new Usuario_AccesosDTO();

       usuario_accesosDTO.setID_USUARIO_ACCESOS(usuario_accesos.getID_USUARIO_ACCESO());
       
//--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID Persona


          Usuario usuario = usuario_accesos.getUsuario();
        if (usuario != null) {
            UsuarioDTO usuarioDTO = UsuarioMapper.DatosAlDTO(usuario);
            usuario_accesosDTO.setID_USUARIO(usuarioDTO);
        }

        //-----------------------------------------------------ID Persona
        
        
        Acceso acceso = usuario_accesos.getAcceso();
      if (acceso != null) {
          AccesoDTO accesoDTO = AccesoMapper.DatosAlDTO(acceso);
          usuario_accesosDTO.setID_ACCESOS(accesoDTO);
      }
        
        
        return usuario_accesosDTO;
    }
    





    public static Usuario_Accesos DatosAlaEdentidad(Usuario_AccesosDTO usuario_accesosDTO){

        Usuario_Accesos usuario_accesos = new Usuario_Accesos();
        usuario_accesos.setID_USUARIO_ACCESO(usuario_accesosDTO.getID_USUARIO_ACCESOS());


    //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Proyecto  
    UsuarioDTO usuarioDTO = usuario_accesosDTO.getID_USUARIO();
    Usuario usuario = (usuarioDTO != null) ? UsuarioMapper.DatosAlaEdentidad(usuarioDTO) : null;
    usuario_accesos.setUsuario(usuario);


    //--------------------------------------------------------------------- Proyecto  
    AccesoDTO accesoDTO = usuario_accesosDTO.getID_ACCESOS();
    Acceso acceso = (accesoDTO != null) ? AccesoMapper.DatosAlaEdentidad(accesoDTO) : null;
    usuario_accesos.setAcceso(acceso);








        

        return usuario_accesos;

    }
    
}
