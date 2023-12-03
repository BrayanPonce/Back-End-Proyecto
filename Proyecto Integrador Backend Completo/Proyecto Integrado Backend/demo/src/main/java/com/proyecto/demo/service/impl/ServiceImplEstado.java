package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.EstadoDTO;
import com.proyecto.demo.Mapper.EstadoMapper;
import com.proyecto.demo.entity.Estado;
import com.proyecto.demo.repository.RepositoryEstado;
import com.proyecto.demo.service.ServiceEstado;

import jakarta.transaction.Transactional;

@Transactional
@Service("estadoServiceImpl")

public class ServiceImplEstado implements ServiceEstado {

    @Autowired
    @Qualifier("estadoRepository")
    private RepositoryEstado repositoryEstado;

    @Override
    public List<EstadoDTO> getAll() {
      List<Estado> estado = repositoryEstado.findAll();  

        return estado.stream().map(EstadoMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public EstadoDTO getById(int id) {
        Estado estado = repositoryEstado.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estado no encontrado"));
    return EstadoMapper.DatosAlDTO(estado);
     }

    @Override
    public EstadoDTO create(EstadoDTO estadoDTO) {
        Estado estado = EstadoMapper.DatosAlaEdentidad(estadoDTO);
        Estado savedEstado = repositoryEstado.save(estado);
        return EstadoMapper.DatosAlDTO(savedEstado);
    }

    @Override
    public EstadoDTO update(int id, EstadoDTO estadoDTO) {
        Estado existingEstado = repositoryEstado.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estado no encontrado"));

// Actualiza los campos del proyecto con los datos del DTO
        existingEstado.setNOMBRE(estadoDTO.getNOMBRE());



        Estado updatedEstado = repositoryEstado.save(existingEstado);
        return EstadoMapper.DatosAlDTO(updatedEstado);    
    }

    @Override
    public void delete(int id) {
        Estado estado = repositoryEstado.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estado no encontrado"));
    repositoryEstado.delete(estado);

    }

  
}
