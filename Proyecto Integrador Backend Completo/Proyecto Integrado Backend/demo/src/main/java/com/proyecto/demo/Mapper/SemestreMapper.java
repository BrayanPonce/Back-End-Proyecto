package com.proyecto.demo.Mapper;






import com.proyecto.demo.DTO.SemestreDTO;
import com.proyecto.demo.entity.Semestre;



public class SemestreMapper {



    public static SemestreDTO SemestreADTO(Semestre semestre) {
        SemestreDTO semestreDTO = new SemestreDTO();
        semestreDTO.setID_SEMESTRE(semestre.getID_SEMESTRE());
        semestreDTO.setNOMBRE(semestre.getNOMBRE());

        return semestreDTO;

    }

    public static Semestre DTOASemestre(SemestreDTO semestreDTO) {  

        Semestre semestre = new Semestre();    
        semestre.setID_SEMESTRE(semestreDTO.getID_SEMESTRE());
        semestre.setNOMBRE(semestreDTO.getNOMBRE());
        return semestre;

    }
}
