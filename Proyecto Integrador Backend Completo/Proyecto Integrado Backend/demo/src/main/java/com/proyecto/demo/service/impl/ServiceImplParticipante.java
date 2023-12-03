package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.ParticipanteDTO;
import com.proyecto.demo.Mapper.ParticipanteMapper;
import com.proyecto.demo.entity.Docente;
import com.proyecto.demo.entity.Estudiante;
import com.proyecto.demo.entity.Participante;
import com.proyecto.demo.entity.Persona;
import com.proyecto.demo.entity.Proyecto;
import com.proyecto.demo.entity.Rol_Proyecto_Encargado;
import com.proyecto.demo.entity.Rol_Sistema;
import com.proyecto.demo.repository.RepositoryDocente;
import com.proyecto.demo.repository.RepositoryEstudiante;
import com.proyecto.demo.repository.RepositoryParticipante;
import com.proyecto.demo.repository.RepositoryPersona;
import com.proyecto.demo.repository.RepositoryProyecto;
import com.proyecto.demo.repository.RepositoryRol_Proyecto_Encargado;
import com.proyecto.demo.repository.RepositoryRol_Sistema;
import com.proyecto.demo.service.ServiceParticipante;

import jakarta.transaction.Transactional;

@Transactional
@Service("participanteServiceImpl")

public class ServiceImplParticipante implements ServiceParticipante {


    @Autowired
    @Qualifier("participanteRepository")
    private RepositoryParticipante repositoryParticipante;

    @Autowired
    @Qualifier("personaRepository")
    private RepositoryPersona repositoryPersona;

    @Autowired
    @Qualifier("rol_sistemaRepository")
    private RepositoryRol_Sistema repositoryRol_Sistema;

    @Autowired
    @Qualifier("docenteRepository")
    private RepositoryDocente repositoryDocente;

    @Autowired
    @Qualifier("estudianteRepository")
    private RepositoryEstudiante repositoryEstudiante;

    @Autowired
    @Qualifier("rol_proyecto_encargadoRepository")
    private RepositoryRol_Proyecto_Encargado repositoryRol_Proyecto_Encargado;

    @Autowired
    @Qualifier("proyectoRepository")
    private RepositoryProyecto repositoryProyecto;






    @Override
    public List<ParticipanteDTO> getAll() {
         List<Participante> var = repositoryParticipante.findAll();  

        return var.stream().map(ParticipanteMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public ParticipanteDTO getById(int id) {
          Participante var = repositoryParticipante.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Participante no encontrado"));
    return ParticipanteMapper.DatosAlDTO(var);
    }

    @Override
    public ParticipanteDTO create(ParticipanteDTO participanteDTO) {
        Participante var = ParticipanteMapper.DatosAlaEntidad(participanteDTO);
        Participante var2 = repositoryParticipante.save(var);
        return ParticipanteMapper.DatosAlDTO(var2);
    }

    @Override
    public ParticipanteDTO update(int id, ParticipanteDTO participanteDTO) {
        Participante existingVar = repositoryParticipante.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Participante no encontrado"));
        existingVar.setHoras(participanteDTO.getHoras());

//Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
//lo capta como null, para despues editarlo

//----------------------------------------------------------------------------------- Rol_Sistema
    if (participanteDTO.getID_ROL_SISTEMA() != null) {
        // Comprueba si tiene un ID_válido
        if (participanteDTO.getID_ROL_SISTEMA().getID_ROL_SISTEMA() != 0) {
            // Busca y asigna el objeto existente basado en el ID proporcionado
            Rol_Sistema rol_Sistema = repositoryRol_Sistema.findById(participanteDTO.getID_ROL_SISTEMA().getID_ROL_SISTEMA())
                    .orElseThrow(() -> new PropertyNotFoundException("Rol_Sistema no encontrado"));
            existingVar.setRol_sistema(rol_Sistema);
        } else {
            // Maneja el caso en el que no se proporciona uno nuevo 
            existingVar.setRol_sistema(null);
        }
    }
//----------------------------------------------------------------------------------- Docente
    if (participanteDTO.getID_DOCENTE() != null) {
        // Comprueba si tiene un ID_válido
        if (participanteDTO.getID_DOCENTE().getID_DOCENTE() != 0) {
            // Busca y asigna el objeto existente basado en el ID proporcionado
            Docente docente = repositoryDocente.findById(participanteDTO.getID_DOCENTE().getID_DOCENTE())
                    .orElseThrow(() -> new PropertyNotFoundException("Docente no encontrado"));
            existingVar.setDocente(docente);
        } else {
            // Maneja el caso en el que no se proporciona uno nuevo 
            existingVar.setDocente(null);
        }
    }


//----------------------------------------------------------------------------------- Estudiante
    if (participanteDTO.getID_ESTUDIANTE() != null) {
        // Comprueba si tiene un ID_válido
        if (participanteDTO.getID_ESTUDIANTE().getID_ESTUDIANTE() != 0) {
            // Busca y asigna el objeto existente basado en el ID proporcionado
            Estudiante estudiante = repositoryEstudiante.findById(participanteDTO.getID_ESTUDIANTE().getID_ESTUDIANTE())
                    .orElseThrow(() -> new PropertyNotFoundException("Estudiante no encontrado"));
            existingVar.setEstudiante(estudiante);
        } else {
            // Maneja el caso en el que no se proporciona uno nuevo 
            existingVar.setEstudiante(null);
        }
    }

//----------------------------------------------------------------------------------- Persona
    if (participanteDTO.getID_PERSONA() != null) {
        // Comprueba si tiene un ID_válido
        if (participanteDTO.getID_PERSONA().getID_PERSONA() != 0) {
            // Busca y asigna el objeto existente basado en el ID proporcionado
            Persona persona = repositoryPersona.findById(participanteDTO.getID_PERSONA().getID_PERSONA())
                    .orElseThrow(() -> new PropertyNotFoundException("Persona no encontrado"));
            existingVar.setPersona(persona);
        } else {
            // Maneja el caso en el que no se proporciona uno nuevo 
            existingVar.setPersona(null);
        }
    }
//----------------------------------------------------------------------------------- Rol_Proyecto_encargado
    if (participanteDTO.getID_ROL_PROYECTO_ENCARGADO() != null) {
        // Comprueba si tiene un ID_válido
        if (participanteDTO.getID_ROL_PROYECTO_ENCARGADO().getID_ROL_PROYECTO_ENCARGADO() != 0) {
            // Busca y asigna el objeto existente basado en el ID proporcionado
            Rol_Proyecto_Encargado rol_proyecto_encargado = repositoryRol_Proyecto_Encargado.findById(participanteDTO.getID_ROL_PROYECTO_ENCARGADO().getID_ROL_PROYECTO_ENCARGADO())
                    .orElseThrow(() -> new PropertyNotFoundException("Rol_Proyecto_Encargado no encontrado"));
            existingVar.setRol_proyecto_encargado(rol_proyecto_encargado);
        } else {
            // Maneja el caso en el que no se proporciona uno nuevo 
            existingVar.setRol_proyecto_encargado(null);
        }
    }
//----------------------------------------------------------------------------------- Proyecto
    if (participanteDTO.getID_PROYECTO() != null) {
        // Comprueba si tiene un ID_válido
        if (participanteDTO.getID_PROYECTO().getID_PROYECTO() != 0) {
            // Busca y asigna el objeto existente basado en el ID proporcionado
            Proyecto proyecto = repositoryProyecto.findById(participanteDTO.getID_PROYECTO().getID_PROYECTO())
                    .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
            existingVar.setProyecto(proyecto);
        } else {
            // Maneja el caso en el que no se proporciona uno nuevo 
            existingVar.setProyecto(null);
        }
    }




        Participante updatedVar = repositoryParticipante.save(existingVar);
        return ParticipanteMapper.DatosAlDTO(updatedVar);    
    }

    @Override
    public void delete(int id) {
        Participante var = repositoryParticipante.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estado no encontrado"));
    repositoryParticipante.delete(var);

  }

  
    
}
