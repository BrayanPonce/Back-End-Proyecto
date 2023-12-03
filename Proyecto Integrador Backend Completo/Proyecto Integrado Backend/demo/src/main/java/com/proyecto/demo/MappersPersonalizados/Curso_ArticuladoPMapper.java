package com.proyecto.demo.MappersPersonalizados;

import com.proyecto.demo.DTOPersonalizados.CursoArticuladoPDTO;
import com.proyecto.demo.entity.CursoArticulado;

public class Curso_ArticuladoPMapper {
    

       public static CursoArticuladoPDTO DatosAlDTO(CursoArticulado cursoarticulado){

        CursoArticuladoPDTO cursoarticuladoDTO = new CursoArticuladoPDTO();

        cursoarticuladoDTO.setID_CURSO_ARTICULADO(cursoarticulado.getID_CURSO_ARTICULADO());
        cursoarticuladoDTO.setNOMBRE(cursoarticulado.getNOMBRE());

        return cursoarticuladoDTO;
    }

    public static CursoArticulado DatosAlaEdentidad(CursoArticuladoPDTO cursoarticuladoDTO){

        CursoArticulado cursoarticulado = new CursoArticulado();

    cursoarticulado.setID_CURSO_ARTICULADO(cursoarticuladoDTO.getID_CURSO_ARTICULADO());
    cursoarticulado.setNOMBRE(cursoarticuladoDTO.getNOMBRE());

    return cursoarticulado;

}
}
