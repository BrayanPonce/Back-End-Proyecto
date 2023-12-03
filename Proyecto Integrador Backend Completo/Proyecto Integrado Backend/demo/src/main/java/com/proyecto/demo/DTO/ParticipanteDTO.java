package com.proyecto.demo.DTO;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.proyecto.demo.DTOPersonalizados.ProyectoPersonalizadoDTO;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ParticipanteDTO {
    private int ID_PARTICIPANTE;
    private int horas;



//-----------------------------------------------------FKS
    private Rol_SistemaDTO ID_ROL_SISTEMA;
    private DocenteDTO ID_DOCENTE;
    private EstudianteDTO ID_ESTUDIANTE;
    private PersonaDTO ID_PERSONA;
    private Rol_Proyecto_EncargadoDTO ID_ROL_PROYECTO_ENCARGADO;
    private ProyectoPersonalizadoDTO ID_PROYECTO;


//-----------------------------------------------------Listas

    private List<Actividad_ParticipanteDTO> actividad_Participante;
    private List<EncargadoDTO> encargado;






    
}
