package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.EncargadoDTO;
import com.proyecto.demo.Mapper.EncargadoMapper;
import com.proyecto.demo.entity.Encargado;
import com.proyecto.demo.entity.Participante;
import com.proyecto.demo.repository.RepositoryEncargado;
import com.proyecto.demo.repository.RepositoryParticipante;
import com.proyecto.demo.service.ServiceEncargado;

import jakarta.transaction.Transactional;

@Transactional
@Service("encargadoServiceImpl")

public class ServiceImplEncargado implements ServiceEncargado {

    @Autowired
    @Qualifier("encargadoRepository")
    private RepositoryEncargado repositoryEncargado;

    @Autowired
    @Qualifier("participanteRepository")
    private RepositoryParticipante repositoryParticipante;

    @Override
    public List<EncargadoDTO> getAll() {
          List<Encargado> var = repositoryEncargado.findAll();  

        return var.stream().map(EncargadoMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public EncargadoDTO getById(int id) {
        Encargado var = repositoryEncargado.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Plantilla no encontrado"));
    return EncargadoMapper.DatosAlDTO(var);
    }

    @Override
    public EncargadoDTO create(EncargadoDTO encargadoDTO) {
        Encargado var = EncargadoMapper.DatosAlaEdentidad(encargadoDTO);
        Encargado var2 = repositoryEncargado.save(var);
        return EncargadoMapper.DatosAlDTO(var2);
     }

    @Override
    public EncargadoDTO update(int id, EncargadoDTO encargadoDTO) {
       Encargado existingVar = repositoryEncargado.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Encargado no encontrado"));

// Actualiza los campos del proyecto con los datos del DTO
        existingVar.setNOMBRE(encargadoDTO.getNOMBRE());
        existingVar.setROL(encargadoDTO.getROL());

    //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Proyecto
    if (encargadoDTO.getID_PARTICIPANTE() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (encargadoDTO.getID_PARTICIPANTE().getID_PARTICIPANTE() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Participante participante = repositoryParticipante.findById(encargadoDTO.getID_PARTICIPANTE().getID_PARTICIPANTE())
                    .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
            existingVar.setParticipante(participante);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setParticipante(null);
        }
    }















        Encargado updatedVar = repositoryEncargado.save(existingVar);
        return EncargadoMapper.DatosAlDTO(updatedVar);    
   }

    @Override
    public void delete(int id) {
        Encargado var = repositoryEncargado.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estado no encontrado"));
    repositoryEncargado.delete(var);

  }

    
}
