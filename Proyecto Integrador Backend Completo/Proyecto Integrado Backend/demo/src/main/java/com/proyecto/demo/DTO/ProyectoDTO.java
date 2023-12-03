package com.proyecto.demo.DTO;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.proyecto.demo.DTOPersonalizados.ParticipantePDTO;

import lombok.Data;



@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ProyectoDTO {
    private int ID_PROYECTO;
    private String NOMBRE;
    private String CODIGO;
    private String COORDINADOR;
    private Date FECHA_INICIO;
    private Date FECHA_FIN;
    private String LUGAR;
    private String OBJETIVOS;
    private String DESCRIPCION;
    private double PRESUPUESTO;
    private String INFORME_FINAL;

//-----------------------------------FKS-----------------------------//   
    private Tipo_De_ConvenioDTO ID_TIPO_DE_CONVENIO;
    private SemestreDTO ID_SEMESTRE;
    private EstadoDTO ID_ESTADO;
    private CicloDTO ID_CICLO;
    private  EscuelaDTO ID_ESCUELA;
    private CursoArticuladoDTO ID_CURSO_ARTICULADO; 

//-----------------------------------LISTAS-----------------------------//

    private List<ActividadesDTO> actividades;
    private List<RecursoDTO> recurso;
    private List<ParticipantePDTO> participante;
    private List<Rol_ProyectoDTO> rol_proyecto;
   
}
