package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.CursoArticuladoDTO;
import com.proyecto.demo.Mapper.Curso_ArticuladoMapper;
import com.proyecto.demo.entity.CursoArticulado;
import com.proyecto.demo.entity.Docente;
import com.proyecto.demo.entity.Escuela;
import com.proyecto.demo.entity.Persona;
import com.proyecto.demo.repository.RepositoryCursoArticulado;
import com.proyecto.demo.repository.RepositoryDocente;
import com.proyecto.demo.repository.RepositoryEscuela;
import com.proyecto.demo.repository.RepositoryPersona;
import com.proyecto.demo.service.ServiceCursoArticulado;

import jakarta.transaction.Transactional;


@Service("cursoarticuladoServiceImpl")
@Transactional

public class ServiceImplCursoArticulado implements ServiceCursoArticulado {

    @Autowired
    @Qualifier("cursoarticuladoRepository")
    private RepositoryCursoArticulado repositoryCursoArticulado;

     @Autowired
    @Qualifier("personaRepository")
    private RepositoryPersona repositoryPersona;

     @Autowired
    @Qualifier("escuelaRepository")
    private RepositoryEscuela repositoryEscuela;

     @Autowired
    @Qualifier("docenteRepository")
    private RepositoryDocente repositoryDocente;

    @Override
    public List<CursoArticuladoDTO> getAll() {
           List<CursoArticulado> proyectos = repositoryCursoArticulado.findAll();
        return proyectos.stream()
                .map(Curso_ArticuladoMapper::DatosAlDTO)
                .collect(Collectors.toList());
  }

    @Override
    public CursoArticuladoDTO getById(int id) {
      CursoArticulado cursoarticulado = repositoryCursoArticulado.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("CursoArticulado no encontrado"));
    return Curso_ArticuladoMapper.DatosAlDTO(cursoarticulado);
   }

    @Override
    public CursoArticuladoDTO create(CursoArticuladoDTO cursoArticuladoDTO) {
        CursoArticulado cursoarticulado = Curso_ArticuladoMapper.DatosAlaEdentidad(cursoArticuladoDTO);
        CursoArticulado savedCursoArticulado = repositoryCursoArticulado.save(cursoarticulado);
        return Curso_ArticuladoMapper.DatosAlDTO(savedCursoArticulado);
       }

    @Override
    public CursoArticuladoDTO update(int id, CursoArticuladoDTO cursoArticuladoDTO) {
        CursoArticulado existingVar = repositoryCursoArticulado.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("CursoArticulado no encontrado"));

        existingVar.setNOMBRE(cursoArticuladoDTO.getNOMBRE());

            //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //-----------------------------------------------------------------------------------Escuela
    if (cursoArticuladoDTO.getID_ESCUELA() != null) {
        // Comprueba si el  tiene un ID válido
        if (cursoArticuladoDTO.getID_ESCUELA().getID_ESCUELA() != 0) {
            // Busca y asigna el objeto  existente basado en el ID proporcionado
            Escuela nuevo = repositoryEscuela.findById(cursoArticuladoDTO.getID_ESCUELA().getID_ESCUELA())
                    .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
            existingVar.setEscuela(nuevo);
        } else {
            // Maneja el caso en el que no se proporciona unO nuevo 
            existingVar.setEscuela(null);
        }
    }

    //-----------------------------------------------------------------------------------Persona
    if (cursoArticuladoDTO.getID_PERSONA() != null) {
        // Comprueba si el  tiene un ID válido
        if (cursoArticuladoDTO.getID_PERSONA().getID_PERSONA() != 0) {
            // Busca y asigna el objeto  existente basado en el ID proporcionado
            Persona nuevo = repositoryPersona.findById(cursoArticuladoDTO.getID_PERSONA().getID_PERSONA())
                    .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
            existingVar.setPersona(nuevo);
        } else {
            // Maneja el caso en el que no se proporciona unO nuevo 
            existingVar.setPersona(null);
        }
    }

        //-----------------------------------------------------------------------------------Docente
    if (cursoArticuladoDTO.getID_DOCENTE() != null) {
        // Comprueba si el  tiene un ID válido
        if (cursoArticuladoDTO.getID_DOCENTE().getID_DOCENTE() != 0) {
            // Busca y asigna el objeto  existente basado en el ID proporcionado
            Docente nuevo = repositoryDocente.findById(cursoArticuladoDTO.getID_DOCENTE().getID_DOCENTE())
                    .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
            existingVar.setDocente(nuevo);
        } else {
            // Maneja el caso en el que no se proporciona unO nuevo 
            existingVar.setDocente(null);
        }
    }



    CursoArticulado updatedCursoArticulado = repositoryCursoArticulado.save(existingVar);
    return Curso_ArticuladoMapper.DatosAlDTO(updatedCursoArticulado);
   }

    @Override
    public void delete(int id) {
        CursoArticulado cursoArticulado = repositoryCursoArticulado.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("C. Articulado no encontrado"));
    repositoryCursoArticulado.delete(cursoArticulado);

 }

  
}
