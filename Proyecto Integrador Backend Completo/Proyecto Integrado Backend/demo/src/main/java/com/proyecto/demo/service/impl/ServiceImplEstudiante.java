package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.EstudianteDTO;
import com.proyecto.demo.Mapper.EstudianteMapper;
import com.proyecto.demo.entity.Ciclo;
import com.proyecto.demo.entity.Estudiante;
import com.proyecto.demo.entity.Grupo_Univ;
import com.proyecto.demo.entity.Persona;
import com.proyecto.demo.repository.RepositoryCiclo;
import com.proyecto.demo.repository.RepositoryEstudiante;
import com.proyecto.demo.repository.RepositoryGrupo_Univ;
import com.proyecto.demo.repository.RepositoryPersona;
import com.proyecto.demo.service.ServiceEstudiante;

import jakarta.transaction.Transactional;


@Transactional
@Service("estudianteServiceImpl")

public class ServiceImplEstudiante implements ServiceEstudiante {

    @Autowired
    @Qualifier("estudianteRepository")
    private RepositoryEstudiante repositoryEstudiante;

    @Autowired
    @Qualifier("grupo_univRepository")
    private RepositoryGrupo_Univ repositoryGrupo_Univ;

    @Autowired
    @Qualifier("cicloRepository")
    private RepositoryCiclo repositoryCiclo;

    @Autowired
    @Qualifier("personaRepository")
    private RepositoryPersona repositoryPersona;

    @Override
    public List<EstudianteDTO> getAll() {
        List<Estudiante> var = repositoryEstudiante.findAll();  

        return var.stream().map(EstudianteMapper::DatosAlDTO).collect(Collectors.toList());
    }

    @Override
    public EstudianteDTO getById(int id) {
         Estudiante var = repositoryEstudiante.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estudiante no encontrado"));
    return EstudianteMapper.DatosAlDTO(var);
    }

    @Override
    public EstudianteDTO create(EstudianteDTO estudianteDTODTO) {
        Estudiante var = EstudianteMapper.DatosAlaEdentidad(estudianteDTODTO);
        Estudiante var2 = repositoryEstudiante.save(var);
        return EstudianteMapper.DatosAlDTO(var2);
    }

    @Override
    public EstudianteDTO update(int id, EstudianteDTO estudianteDTO) {
        Estudiante existingVar = repositoryEstudiante.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estudiante no encontrado"));

// Actualiza los campos del proyecto con los datos del DTO
        existingVar.setCODIGO(estudianteDTO.getCODIGO());
        existingVar.setHORAS_TOTALES(estudianteDTO.getHORAS_TOTALES());

           //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Ciclo
    if (estudianteDTO.getID_CICLO() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (estudianteDTO.getID_CICLO().getID_CICLO() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Ciclo ciclo = repositoryCiclo.findById(estudianteDTO.getID_CICLO().getID_CICLO())
                    .orElseThrow(() -> new PropertyNotFoundException("Ciclo no encontrado"));
            existingVar.setCiclo(ciclo);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setCiclo(null);
        }
    }

     //----------------------------------------------------------------------------------- Grupo_Univ
    if (estudianteDTO.getID_GRUPO_UNIV() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (estudianteDTO.getID_GRUPO_UNIV().getID_GRUPO_UNIV() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Grupo_Univ grupo_Univ = repositoryGrupo_Univ.findById(estudianteDTO.getID_GRUPO_UNIV().getID_GRUPO_UNIV())
                    .orElseThrow(() -> new PropertyNotFoundException("Grupo_Univ no encontrado"));
            existingVar.setGrupo_univ(grupo_Univ);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setGrupo_univ(null);
        }
    }

        
    //----------------------------------------------------------------------------------- Persona
    if (estudianteDTO.getID_PERSONA() != null) {
        // Comprueba si tiene un ID_ válido
        if (estudianteDTO.getID_PERSONA().getID_PERSONA() != 0) {
            // Busca y asigna el objeto  existente basado en el ID proporcionado
            Persona persona = repositoryPersona.findById(estudianteDTO.getID_PERSONA().getID_PERSONA())
                    .orElseThrow(() -> new PropertyNotFoundException("Persona no encontrado"));
            existingVar.setPersona(persona);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setPersona(null);
        }
    }









        Estudiante updatedVar = repositoryEstudiante.save(existingVar);
        return EstudianteMapper.DatosAlDTO(updatedVar);    
   }

    @Override
    public void delete(int id) {
        Estudiante var = repositoryEstudiante.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estudiante no encontrado"));
    repositoryEstudiante.delete(var);

 }

  
}
