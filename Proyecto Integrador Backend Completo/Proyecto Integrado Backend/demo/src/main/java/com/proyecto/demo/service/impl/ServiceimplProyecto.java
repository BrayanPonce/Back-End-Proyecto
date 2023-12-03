package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.ProyectoDTO;
import com.proyecto.demo.Mapper.ProyectoMapper;
import com.proyecto.demo.entity.Ciclo;
import com.proyecto.demo.entity.CursoArticulado;
import com.proyecto.demo.entity.Escuela;
import com.proyecto.demo.entity.Estado;
import com.proyecto.demo.entity.Proyecto;
import com.proyecto.demo.entity.Semestre;
import com.proyecto.demo.entity.Tipo_De_Convenio;
import com.proyecto.demo.repository.RepositoryCiclo;
import com.proyecto.demo.repository.RepositoryCursoArticulado;
import com.proyecto.demo.repository.RepositoryEscuela;
import com.proyecto.demo.repository.RepositoryEstado;
import com.proyecto.demo.repository.RepositoryProyecto;
import com.proyecto.demo.repository.RepositorySemestre;
import com.proyecto.demo.repository.RepositoryTipo_De_Convenio;
import com.proyecto.demo.service.ServiceProyecto;
import org.hibernate.PropertyNotFoundException;
import jakarta.transaction.Transactional;

@Service("proyectoServiceImpl")
@Transactional


public class ServiceimplProyecto implements ServiceProyecto {


    @Autowired
    @Qualifier("proyectoRepository")
    private RepositoryProyecto repositoryProyecto;

    @Autowired
    @Qualifier("semestreRepository")
    private RepositorySemestre semestreRepository;

    @Autowired
    @Qualifier("escuelaRepository")
    private RepositoryEscuela escuelaRepository;

    @Autowired
    @Qualifier("estadoRepository")
    private RepositoryEstado estadoRepository;

    @Autowired
    @Qualifier("tipo_de_convenioRepository")
    private RepositoryTipo_De_Convenio RPTDC;

    @Autowired
    @Qualifier("cursoarticuladoRepository")
    private RepositoryCursoArticulado CAT;

    @Autowired
    @Qualifier("cicloRepository")
    private RepositoryCiclo CICLORE;




    @Override
    public List<ProyectoDTO> getAllProyectos() {
        List<Proyecto> proyectos = repositoryProyecto.findAll();
        return proyectos.stream()
                .map(ProyectoMapper::DatosAlDTO)
                .collect(Collectors.toList());

     
    }


    @Override
    public ProyectoDTO getProyectoById(int id) {
        Proyecto proyecto = repositoryProyecto.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
    return ProyectoMapper.DatosAlDTO(proyecto);
    }


    @Override
    public ProyectoDTO createProyecto(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = ProyectoMapper.DatosAlaEdentidad(proyectoDTO);
        Proyecto savedProyecto = repositoryProyecto.save(proyecto);
        return ProyectoMapper.DatosAlDTO(savedProyecto);
     }   


    @Override
    public ProyectoDTO updateProyecto(int id, ProyectoDTO proyectoDTO) {
    Proyecto existingProyecto = repositoryProyecto.findById(id)
            .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));

    // Actualiza los campos del proyecto con los datos del DTO
    existingProyecto.setNOMBRE(proyectoDTO.getNOMBRE());
    existingProyecto.setCODIGO(proyectoDTO.getCODIGO());
    existingProyecto.setCOORDINADOR(proyectoDTO.getCOORDINADOR());
    existingProyecto.setFECHA_INICIO(proyectoDTO.getFECHA_INICIO());
    existingProyecto.setFECHA_FIN(proyectoDTO.getFECHA_FIN());
    existingProyecto.setLUGAR(proyectoDTO.getLUGAR());
    existingProyecto.setOBJETIVOS(proyectoDTO.getOBJETIVOS());
    existingProyecto.setDESCRIPCION(proyectoDTO.getDESCRIPCION());
    existingProyecto.setPRESUPUESTO(proyectoDTO.getPRESUPUESTO());
    existingProyecto.setINFORME_FINAL(proyectoDTO.getINFORME_FINAL());

   
    //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //-----------------------------------------------------------------------------------SEMESTRE    
    if (proyectoDTO.getID_SEMESTRE() != null) {
        // Comprueba si el Semestre tiene un ID_SEMESTRE válido
        if (proyectoDTO.getID_SEMESTRE().getID_SEMESTRE() != 0) {
            // Busca y asigna el objeto Semestre existente basado en el ID proporcionado
            Semestre semestre = semestreRepository.findById(proyectoDTO.getID_SEMESTRE().getID_SEMESTRE())
                    .orElseThrow(() -> new PropertyNotFoundException("Semestre no encontrado"));
            existingProyecto.setSemestre(semestre);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Semestre
            existingProyecto.setSemestre(null);
        }
    }
    //-----------------------------------------------------------------------------------ESCUELA
    if (proyectoDTO.getID_ESCUELA() != null) {
        // Comprueba si el ESCUELA tiene un ID_ESCUELA válido
        if (proyectoDTO.getID_ESCUELA().getID_ESCUELA() != 0) {
            // Busca y asigna el objeto ESCUELA existente basado en el ID proporcionado
            Escuela escuela = escuelaRepository.findById(proyectoDTO.getID_ESCUELA().getID_ESCUELA())
                    .orElseThrow(() -> new PropertyNotFoundException("ESCUELA no encontrado"));
            existingProyecto.setEscuela(escuela);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo ESCUELA
            existingProyecto.setEscuela(null);
        }
    }
    //-----------------------------------------------------------------------------------ESTADO
    if (proyectoDTO.getID_ESTADO() != null) {
        // Comprueba si el ESTADO tiene un ID_ESTADO válido
        if (proyectoDTO.getID_ESTADO().getID_ESTADO() != 0) {
            // Busca y asigna el objeto ESTADO existente basado en el ID proporcionado
            Estado estado = estadoRepository.findById(proyectoDTO.getID_ESTADO().getID_ESTADO())
                    .orElseThrow(() -> new PropertyNotFoundException("ESTADO no encontrado"));
            existingProyecto.setEstado(estado);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo ESTADO
            existingProyecto.setEstado(null);
        }
    }
    //-----------------------------------------------------------------------------------TIPO_DE_CONVENIO
     if (proyectoDTO.getID_TIPO_DE_CONVENIO() != null) {
        // Comprueba si el TIPO_CONVENIO tiene un ID_ESTADO válido
        if (proyectoDTO.getID_TIPO_DE_CONVENIO().getID_TIPO_DE_CONVENIO() != 0) {
            // Busca y asigna el objeto TIPO_CONVENIO existente basado en el ID proporcionado
            Tipo_De_Convenio tipo_De_Convenio = RPTDC.findById(proyectoDTO.getID_TIPO_DE_CONVENIO().getID_TIPO_DE_CONVENIO())
                    .orElseThrow(() -> new PropertyNotFoundException("TIPO_CONVENIO no encontrado"));
            existingProyecto.setTipo_de_convenio(tipo_De_Convenio);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo TIPO_CONVENIO
            existingProyecto.setTipo_de_convenio(null);
        }
    }
    //-----------------------------------------------------------------------------------CursoArticulado

     if (proyectoDTO.getID_CURSO_ARTICULADO() != null) {
        // Comprueba si CURSO_ARTICULADO tiene un ID_ESTADO válido
        if (proyectoDTO.getID_CURSO_ARTICULADO().getID_CURSO_ARTICULADO() != 0) {
            // Busca y asigna el objeCURSO_ARTICULADO existente basado en el ID proporcionado
            CursoArticulado cursoArticulado = CAT.findById(proyectoDTO.getID_CURSO_ARTICULADO().getID_CURSO_ARTICULADO())
                    .orElseThrow(() ->  new PropertyNotFoundException("Curso Articulado no encontrado"));
            existingProyecto.setCursoarticulado(cursoArticulado);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo CURSO_ARTICULADO
            existingProyecto.setCursoarticulado(null);
        }
    }
    //-----------------------------------------------------------------------------------Ciclo

     if (proyectoDTO.getID_CICLO() != null) {
        // Comprueba si CICLO tiene un ID_ESTADO válido
        if (proyectoDTO.getID_CICLO().getID_CICLO() != 0) {
            // Busca y asigna el objeto CICLO existente basado en el ID proporcionado
            Ciclo ciclo = CICLORE.findById(proyectoDTO.getID_CICLO().getID_CICLO())
                    .orElseThrow(() ->  new PropertyNotFoundException("Ciclo Articulado no encontrado"));
            existingProyecto.setCiclo(ciclo);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo CICLO
            existingProyecto.setCiclo(null);
        }
    }
//-----------------------------------------------------------------------------------Termina----------------------------------------------------------------------------//
    Proyecto updatedProyecto = repositoryProyecto.save(existingProyecto);
    return ProyectoMapper.DatosAlDTO(updatedProyecto);
    }

    @Override
    public void deleteProyecto(int id) {
        Proyecto proyecto = repositoryProyecto.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
        repositoryProyecto.delete(proyecto);
       
    }


    @Override
    public List<ProyectoDTO> getProyectosPorNombre(String nombre) {
        List<Proyecto> proyectos = repositoryProyecto.findByNOMBRE(nombre);
        return proyectos.stream()
                .map(ProyectoMapper::DatosAlDTO)
                .collect(Collectors.toList());
    }

  

    
}
