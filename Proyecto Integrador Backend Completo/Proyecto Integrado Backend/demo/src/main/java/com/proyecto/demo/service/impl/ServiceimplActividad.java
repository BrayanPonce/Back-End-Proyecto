package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.ActividadesDTO;
import com.proyecto.demo.Mapper.ActividadesMapper;
import com.proyecto.demo.entity.Actividad;
import com.proyecto.demo.entity.Encargado;
import com.proyecto.demo.entity.Proyecto;
import com.proyecto.demo.repository.RepositoryActividad;
import com.proyecto.demo.repository.RepositoryEncargado;
import com.proyecto.demo.repository.RepositoryProyecto;
import com.proyecto.demo.service.ServiceActividad;
import jakarta.transaction.Transactional;

@Service("actividadServiceImpl")
@Transactional


public class ServiceimplActividad implements ServiceActividad {

    @Autowired
    @Qualifier("actividadRepository")
    private RepositoryActividad repositoryActividad;

    @Autowired
    @Qualifier("proyectoRepository")
    private RepositoryProyecto repositoryProyecto;

    @Autowired
    @Qualifier("encargadoRepository")
    private RepositoryEncargado repositoryEncargado;

    @Override
    public List<ActividadesDTO> getAll() {
         List<Actividad> var = repositoryActividad.findAll();  

        return var.stream().map(ActividadesMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public ActividadesDTO getById(int id) {
        Actividad var = repositoryActividad.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Plantilla no encontrado"));
    return ActividadesMapper.DatosAlDTO(var);
    }

    @Override
    public ActividadesDTO create(ActividadesDTO actividadDTO) {
        Actividad var = ActividadesMapper.DatosAlaEntidad(actividadDTO);
        Actividad var2 = repositoryActividad.save(var);
        return ActividadesMapper.DatosAlDTO(var2);
     }

    @Override
    public ActividadesDTO update(int id, ActividadesDTO actividadDTO) {
         Actividad existingVar = repositoryActividad.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Actividad no encontrado"));

// Actualiza los campos del proyecto con los datos del DTO
        existingVar.setNOMBRE(actividadDTO.getNOMBRE());
        existingVar.setFECHA(actividadDTO.getFECHA());



         //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
        //lo capta como null, para despues editarlo

         //----------------------------------------------------------------------------------- Proyecto

         if (actividadDTO.getID_PROYECTO() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (actividadDTO.getID_PROYECTO().getID_PROYECTO() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Proyecto proyecto = repositoryProyecto.findById(actividadDTO.getID_PROYECTO().getID_PROYECTO())
                    .orElseThrow(() -> new PropertyNotFoundException("Proyecto no encontrado"));
            existingVar.setProyecto(proyecto);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setProyecto(null);
        }
             }

//----------------------------------------------------------------------------------- Encargado

    if (actividadDTO.getID_ENCARGADO() != null) {
        // Comprueba si el Encargado tiene un id_encargado válido
        if (actividadDTO.getID_ENCARGADO().getID_ENCARGADO() != 0) {
            // Busca y asigna el objeto Encargado existente basado en el ID proporcionado
            Encargado encargado = repositoryEncargado.findById(actividadDTO.getID_ENCARGADO().getID_ENCARGADO())
                    .orElseThrow(() -> new PropertyNotFoundException("Encargado no encontrado"));
            existingVar.setEncargado(encargado);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Encargado
            existingVar.setEncargado(null);
        }
    }


        Actividad updatedVar = repositoryActividad.save(existingVar);
        return ActividadesMapper.DatosAlDTO(updatedVar);    
   }

    @Override
    public void delete(int id) {
        Actividad var = repositoryActividad.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Actividad no encontrado"));
    repositoryActividad.delete(var);

    }

    
}
