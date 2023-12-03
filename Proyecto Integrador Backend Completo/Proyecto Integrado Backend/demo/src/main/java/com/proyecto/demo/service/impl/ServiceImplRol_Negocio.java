package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.Rol_NegocioDTO;
import com.proyecto.demo.Mapper.Rol_NegocioMapper;
import com.proyecto.demo.entity.Rol_Negocio;
import com.proyecto.demo.repository.RepositoryRol_Negocio;
import com.proyecto.demo.service.ServiceRol_Negocio;

import jakarta.transaction.Transactional;

@Transactional
@Service("rol_negocioServiceImpl")

public class ServiceImplRol_Negocio implements ServiceRol_Negocio {
    @Autowired
    @Qualifier("rol_negocioRepository")
    private RepositoryRol_Negocio repositoryRol_Negocio;

    @Override
    public List<Rol_NegocioDTO> getAll() {
       List<Rol_Negocio> rol_negocio = repositoryRol_Negocio.findAll();  

        return rol_negocio.stream().map(Rol_NegocioMapper::DatosAlDTO).collect(Collectors.toList());
  }

    @Override
    public Rol_NegocioDTO getById(int id) {
         Rol_Negocio rol_negocio = repositoryRol_Negocio.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Rol_Negocio no encontrado"));
    return Rol_NegocioMapper.DatosAlDTO(rol_negocio);
      }

    @Override
    public Rol_NegocioDTO create(Rol_NegocioDTO rol_negocioDTO) {
        Rol_Negocio rol_Negocio = Rol_NegocioMapper.DatosAlaEdentidad(rol_negocioDTO);
        Rol_Negocio savedRol_Negocio = repositoryRol_Negocio.save(rol_Negocio);
        return Rol_NegocioMapper.DatosAlDTO(savedRol_Negocio);
    }

    @Override
    public Rol_NegocioDTO update(int id, Rol_NegocioDTO rol_negocioDTO) {
        Rol_Negocio existingRol_Negocio = repositoryRol_Negocio.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Rol_Negocio no encontrado"));

    // Actualiza los campos del prRol_Negocio con los datos del DTO
        existingRol_Negocio.setNOMBRE(rol_negocioDTO.getNOMBRE());

        Rol_Negocio updatedRol_Negocio = repositoryRol_Negocio.save(existingRol_Negocio);
        return Rol_NegocioMapper.DatosAlDTO(updatedRol_Negocio);    
     }

    @Override
    public void delete(int id) {
        Rol_Negocio rol_negocio = repositoryRol_Negocio.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("rol_negocio no encontrado"));
    repositoryRol_Negocio.delete(rol_negocio);

    }

 
   
}
