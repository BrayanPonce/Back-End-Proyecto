package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.EscuelaDTO;
import com.proyecto.demo.Mapper.EscuelaMapper;
import com.proyecto.demo.entity.Escuela;
import com.proyecto.demo.entity.Facultad;
import com.proyecto.demo.repository.RepositoryEscuela;
import com.proyecto.demo.repository.RepositoryFacultad;
import com.proyecto.demo.service.ServiceEscuela;

import jakarta.transaction.Transactional;

@Service("escuelaServiceImpl")
@Transactional
public class ServiceImplEscuela implements ServiceEscuela {

  @Autowired
  @Qualifier("escuelaRepository")
  private RepositoryEscuela repositoryEscuela;

  @Autowired
  @Qualifier("facultadRepository")
  private RepositoryFacultad repositoryFacultad;

  @Override
  public List<EscuelaDTO> getAllEscuela() {
    List<Escuela> proyectos = repositoryEscuela.findAll();
    return proyectos.stream()
        .map(EscuelaMapper::DatosAlDTO)
        .collect(Collectors.toList());
  }

  @Override
  public EscuelaDTO getEscuelaById(int id) {
    Escuela escuela = repositoryEscuela.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Escuela no encontrado"));
    return EscuelaMapper.DatosAlDTO(escuela);
  }

  @Override
  public EscuelaDTO createEscuela(EscuelaDTO escuelaDTO) {
    Escuela escuela = EscuelaMapper.DatosAlaEdentidad(escuelaDTO);
    Escuela savedEscuela = repositoryEscuela.save(escuela);
    return EscuelaMapper.DatosAlDTO(savedEscuela);
  }

  @Override
  public EscuelaDTO updateEscuela(int id, EscuelaDTO escuelaDTO) {
    Escuela existingEscuela = repositoryEscuela.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Escuela no encontrado"));

    // Actualiza los campos del proyecto con los datos del DTO
    existingEscuela.setNOMBRE(escuelaDTO.getNOMBRE());











     //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Proyecto
    if (escuelaDTO.getID_FACULTAD() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (escuelaDTO.getID_FACULTAD().getID_FACULTAD() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Facultad facultad = repositoryFacultad.findById(escuelaDTO.getID_FACULTAD().getID_FACULTAD())
                    .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
            existingEscuela.setFACULTAD(facultad);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingEscuela.setFACULTAD(null);
        }
    }



















    Escuela updatedEscuela = repositoryEscuela.save(existingEscuela);
    return EscuelaMapper.DatosAlDTO(updatedEscuela);
  }

  @Override
  public void deleteEscuela(int id) {
    Escuela escuela = repositoryEscuela.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Escuela no encontrado"));
    repositoryEscuela.delete(escuela);

  }

}
