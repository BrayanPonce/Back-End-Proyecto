package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.AccesoDTO;
import com.proyecto.demo.DTO.Rol_SistemaDTO;
import com.proyecto.demo.DTO.Rol_Sistema_AccesosDTO;
import com.proyecto.demo.entity.Acceso;
import com.proyecto.demo.entity.Rol_Sistema;
import com.proyecto.demo.entity.Rol_Sistema_Accesos;

public class Rol_Sistema_AccesosMapper {

    public static Rol_Sistema_AccesosDTO DatosAlDTO(Rol_Sistema_Accesos Rol_Sistema_Accesos){
       Rol_Sistema_AccesosDTO Rol_Sistema_AccesosDTO = new Rol_Sistema_AccesosDTO();

       Rol_Sistema_AccesosDTO.setID_ROL_SISTEMA_ACCESOS(Rol_Sistema_Accesos.getID_ROL_SISTEMA_ACCESOS());
      
//--------------------------------------- IDS QUE JALA ---------------------------------//
 
//-----------------------------------------------------ID PARTICIPANTE


          Rol_Sistema rol_Sistema = Rol_Sistema_Accesos.getRol_sistema();
        if (rol_Sistema != null) {
            Rol_SistemaDTO rol_SistemaDTO = Rol_SistemaMapper.DatosAlDTO(rol_Sistema);
            Rol_Sistema_AccesosDTO.setID_ROL_SISTEMA(rol_SistemaDTO);
        }
//-----------------------------------------------------ID PARTICIPANTE


          Acceso accesos = Rol_Sistema_Accesos.getAcceso();
        if (accesos != null) {
            AccesoDTO accesosDTO = AccesoMapper.DatosAlDTO(accesos);
            Rol_Sistema_AccesosDTO.setID_ACCESOS(accesosDTO);
        }



        return Rol_Sistema_AccesosDTO;
    }



    public static Rol_Sistema_Accesos DatosAlaEdentidad(Rol_Sistema_AccesosDTO Rol_Sistema_AccesosDTO){

        Rol_Sistema_Accesos Rol_Sistema_Accesos = new Rol_Sistema_Accesos();

    //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Proyecto  
        Rol_SistemaDTO rol_SistemaDTO = Rol_Sistema_AccesosDTO.getID_ROL_SISTEMA();
        Rol_Sistema rol_Sistema = (rol_SistemaDTO != null) ? Rol_SistemaMapper.DatosAlaEdentidad(rol_SistemaDTO) : null;
        Rol_Sistema_Accesos.setRol_sistema(rol_Sistema);

//--------------------------------------------------------------------- Proyecto  
        AccesoDTO accesosDTO = Rol_Sistema_AccesosDTO.getID_ACCESOS();
        Acceso accesos = (accesosDTO != null) ? AccesoMapper.DatosAlaEdentidad(accesosDTO) : null;
        Rol_Sistema_Accesos.setAcceso(accesos);
     
     
       

        return Rol_Sistema_Accesos;

    }


 
}
