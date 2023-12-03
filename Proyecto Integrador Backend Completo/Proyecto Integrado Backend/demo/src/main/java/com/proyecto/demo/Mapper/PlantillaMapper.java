package com.proyecto.demo.Mapper;

import com.proyecto.demo.DTO.PlantillaDTO;
import com.proyecto.demo.DTO.Tipo_De_ConvenioDTO;
import com.proyecto.demo.entity.Plantilla;
import com.proyecto.demo.entity.Tipo_De_Convenio;

public class PlantillaMapper {

    
    public static PlantillaDTO DatosAlDTO(Plantilla plantilla){
       PlantillaDTO plantillaDTO = new PlantillaDTO();

       plantillaDTO.setID_PLANTILLA(plantilla.getID_PLANTILLA());
       plantillaDTO.setNOMBRE(plantilla.getNOMBRE()); 
       plantillaDTO.setURL(plantilla.getURL()); 
 
//-----------------------------------------------------ID PARTICIPANTE


        Tipo_De_Convenio tipo_de_convenio = plantilla.getTipo_de_convenio();
        if (tipo_de_convenio != null) {
            Tipo_De_ConvenioDTO tipo_de_convenioDTO = Tipo_De_ConvenioMapper.DatosAlDTO(tipo_de_convenio);
            plantillaDTO.setID_TIPO_DE_CONVENIO(tipo_de_convenioDTO);
        }




        return plantillaDTO;
    }



    public static Plantilla DatosAlaEdentidad(PlantillaDTO plantillaDTO){

        Plantilla plantilla = new Plantilla();
        plantilla.setID_PLANTILLA(plantillaDTO.getID_PLANTILLA());
        plantilla.setNOMBRE(plantillaDTO.getNOMBRE());
        plantilla.setURL(plantillaDTO.getURL());



     //Los codigos de abajo son para la ocacion de Editar porque cuando agregue un Proyecto
    //Sino se sube algun dato, esto lo toma como null,
    // para despues puedas editar ese espacio

    //--------------------------------------------------------------------- Proyecto  
        Tipo_De_ConvenioDTO tipo_De_ConvenioDTO = plantillaDTO.getID_TIPO_DE_CONVENIO();
        Tipo_De_Convenio tipo_De_Convenio = (tipo_De_ConvenioDTO != null) ? Tipo_De_ConvenioMapper.DatosAlaEdentidad(tipo_De_ConvenioDTO) : null;
        plantilla.setTipo_de_convenio(tipo_De_Convenio);

        return plantilla;

    }
    
}
