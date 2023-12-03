package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.Actividad_ParticipanteDTO;
import com.proyecto.demo.Mapper.Actividad_ParticipanteMapper;
import com.proyecto.demo.entity.Actividad;
import com.proyecto.demo.entity.Actividad_Participante;
import com.proyecto.demo.entity.Participante;
import com.proyecto.demo.repository.RepositoryActividad;
import com.proyecto.demo.repository.RepositoryActividad_Participante;
import com.proyecto.demo.repository.RepositoryParticipante;
import com.proyecto.demo.service.ServiceActividad_Participante;

import jakarta.transaction.Transactional;

@Transactional
@Service("actividad_participanteServiceImpl")


public class ServiceImplActividad_Participante implements ServiceActividad_Participante {

    @Autowired
    @Qualifier("actividad_participanteRepository")
    private RepositoryActividad_Participante repositoryActividad_Participante;

   @Autowired
    @Qualifier("participanteRepository")
    private RepositoryParticipante repositoryParticipante;


    @Autowired
    @Qualifier("actividadRepository")
    private RepositoryActividad repositoryActividad;


    @Override
    public List<Actividad_ParticipanteDTO> getAll() {
         List<Actividad_Participante> var = repositoryActividad_Participante.findAll();  

        return var.stream().map(Actividad_ParticipanteMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public Actividad_ParticipanteDTO getById(int id) {
         Actividad_Participante var = repositoryActividad_Participante.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Actividad_Participante no encontrado"));
    return Actividad_ParticipanteMapper.DatosAlDTO(var);
     }

    @Override
    public Actividad_ParticipanteDTO create(Actividad_ParticipanteDTO actividad_ParticipanteDTO) {
        Actividad_Participante var = Actividad_ParticipanteMapper.DatosAlaEdentidad(actividad_ParticipanteDTO);
        Actividad_Participante var2 = repositoryActividad_Participante.save(var);
        return Actividad_ParticipanteMapper.DatosAlDTO(var2);
   }

    @Override
    public Actividad_ParticipanteDTO update(int id, Actividad_ParticipanteDTO actividad_ParticipanteDTO) {
        Actividad_Participante existingVar = repositoryActividad_Participante.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Actividad_Participante no encontrado"));
        existingVar.setASISTENCIA(actividad_ParticipanteDTO.isAsistencia());


          //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Proyecto
    if (actividad_ParticipanteDTO.getID_PARTICIPANTE() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (actividad_ParticipanteDTO.getID_PARTICIPANTE().getID_PARTICIPANTE() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Participante participante = repositoryParticipante.findById(actividad_ParticipanteDTO.getID_PARTICIPANTE().getID_PARTICIPANTE())
                    .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
            existingVar.setParticipante(participante);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setParticipante(null);
        }
    }


    //----------------------------------------------------------------------------------- Proyecto

      if (actividad_ParticipanteDTO.getID_ACTIVIDAD() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (actividad_ParticipanteDTO.getID_ACTIVIDAD().getID_ACTIVIDAD() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Actividad actividad = repositoryActividad.findById(actividad_ParticipanteDTO.getID_ACTIVIDAD().getID_ACTIVIDAD())
                    .orElseThrow(() -> new PropertyNotFoundException("Actividad no encontrado"));
            existingVar.setActividad(actividad);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setActividad(null);
        }
    }






        Actividad_Participante updatedVar = repositoryActividad_Participante.save(existingVar);
        return Actividad_ParticipanteMapper.DatosAlDTO(updatedVar);    
  }

    @Override
    public void delete(int id) {
        Actividad_Participante var = repositoryActividad_Participante.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Actividad_P no encontrado"));
    repositoryActividad_Participante.delete(var);

  }

}
