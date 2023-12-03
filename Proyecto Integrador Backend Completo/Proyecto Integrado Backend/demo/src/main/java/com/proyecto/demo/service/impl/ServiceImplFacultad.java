package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.FacultadDTO;
import com.proyecto.demo.Mapper.FacultadMapper;
import com.proyecto.demo.entity.Facultad;
import com.proyecto.demo.repository.RepositoryFacultad;
import com.proyecto.demo.service.ServiceFacultad;

import jakarta.transaction.Transactional;


@Transactional
@Service("facultadServiceImpl")

public class ServiceImplFacultad implements ServiceFacultad {

    @Autowired
    @Qualifier("facultadRepository")
    private RepositoryFacultad repositoryFacultad;

    @Override
    public List<FacultadDTO> getAll() {
        List<Facultad> var = repositoryFacultad.findAll();  

        return var.stream().map(FacultadMapper::DatosAlDTO).collect(Collectors.toList());
  }

    @Override
    public FacultadDTO getById(int id) {
        Facultad var = repositoryFacultad.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Plantilla no encontrado"));
    return FacultadMapper.DatosAlDTO(var);
    }

    @Override
    public FacultadDTO create(FacultadDTO facultadDTO) {
        Facultad var = FacultadMapper.DatosAlaEdentidad(facultadDTO);
        Facultad var2 = repositoryFacultad.save(var);
        return FacultadMapper.DatosAlDTO(var2);
    }

    @Override
    public FacultadDTO update(int id, FacultadDTO facultadDTO) {
        Facultad existingVar = repositoryFacultad.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Facultad no encontrado"));

    // Actualiza los campos del proyecto con los datos del DTO
        existingVar.setNOMBRE(facultadDTO.getNOMBRE());


        Facultad updatedVar = repositoryFacultad.save(existingVar);
        return FacultadMapper.DatosAlDTO(updatedVar);    
  }

    @Override
    public void delete(int id) {
         Facultad var = repositoryFacultad.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estado no encontrado"));
    repositoryFacultad.delete(var);

  }

    
}
