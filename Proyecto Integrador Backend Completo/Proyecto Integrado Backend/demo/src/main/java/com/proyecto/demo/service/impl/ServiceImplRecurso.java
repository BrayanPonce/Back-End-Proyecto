package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.RecursoDTO;
import com.proyecto.demo.Mapper.RecursoMapper;
import com.proyecto.demo.entity.Proyecto;
import com.proyecto.demo.entity.Recurso;
import com.proyecto.demo.repository.RepositoryProyecto;
import com.proyecto.demo.repository.RepositoryRecurso;
import com.proyecto.demo.service.ServiceRecurso;

import jakarta.transaction.Transactional;

@Service("recursoServiceImpl")
@Transactional

public class ServiceImplRecurso implements ServiceRecurso {

    @Autowired
    @Qualifier("recursoRepository")
    private RepositoryRecurso repositoryRecurso;

    @Autowired
    @Qualifier("proyectoRepository")
    private RepositoryProyecto repositoryProyecto;

    @Override
    public List<RecursoDTO> getAll() {
       List<Recurso> recurso = repositoryRecurso.findAll();
        return recurso.stream()
                .map(RecursoMapper::entidadADTO)
                .collect(Collectors.toList());

   }

    @Override
    public RecursoDTO getById(int id) {
     Recurso recurso = repositoryRecurso.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Recurso no encontrado"));
    return RecursoMapper.entidadADTO(recurso);
    


   }

    @Override
    public RecursoDTO create(RecursoDTO recursoDTO) {
        Recurso recurso = RecursoMapper.DatosAlaEntidad(recursoDTO);
        Recurso savedRecurso = repositoryRecurso.save(recurso);
        return RecursoMapper.entidadADTO(savedRecurso);
     }


    @Override
    public RecursoDTO update(int id, RecursoDTO recursoDTO) {
 Recurso existingRecurso = repositoryRecurso.findById(id)
            .orElseThrow(() -> new PropertyNotFoundException("Recurso no encontrado"));

    // Actualiza los campos del proyecto con los datos del DTO
    existingRecurso.setNOMBRE(recursoDTO.getNOMBRE());
    existingRecurso.setURL(recursoDTO.getURL());





    
    //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Proyecto
    if (recursoDTO.getID_PROYECTO() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (recursoDTO.getID_PROYECTO().getID_PROYECTO() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Proyecto proyecto = repositoryProyecto.findById(recursoDTO.getID_PROYECTO().getID_PROYECTO())
                    .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
            existingRecurso.setProyecto(proyecto);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingRecurso.setProyecto(null);
        }
    }


    Recurso updatedRecurso = repositoryRecurso.save(existingRecurso);
    return RecursoMapper.entidadADTO(updatedRecurso);
    }


    @Override
    public void delete(int id) {
           Recurso recurso = repositoryRecurso.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Recurso no encontrado"));
    repositoryRecurso.delete(recurso);

   }

    
}
