package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.Rol_SistemaDTO;
import com.proyecto.demo.Mapper.Rol_SistemaMapper;
import com.proyecto.demo.entity.Rol_Sistema;
import com.proyecto.demo.repository.RepositoryRol_Sistema;
import com.proyecto.demo.service.ServiceRol_Sistema;

import jakarta.transaction.Transactional;

@Transactional
@Service("rol_sistemaServiceImpl")


public class ServiceImplRol_Sistema implements ServiceRol_Sistema {
    @Autowired
    @Qualifier("rol_sistemaRepository")
    private RepositoryRol_Sistema repositoryRol_Sistema;

    @Override
    public List<Rol_SistemaDTO> getAll() {
       List<Rol_Sistema> rol_sistema = repositoryRol_Sistema.findAll();  

        return rol_sistema.stream().map(Rol_SistemaMapper::DatosAlDTO).collect(Collectors.toList());
    }

    @Override
    public Rol_SistemaDTO getById(int id) {
         Rol_Sistema rol_sistema = repositoryRol_Sistema.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Rol_Sistema no encontrado"));
    return Rol_SistemaMapper.DatosAlDTO(rol_sistema);
     }

    @Override
    public Rol_SistemaDTO create(Rol_SistemaDTO rol_SistemaDTO) {
        Rol_Sistema rol_sistema = Rol_SistemaMapper.DatosAlaEdentidad(rol_SistemaDTO);
        Rol_Sistema savedRol_Sistema = repositoryRol_Sistema.save(rol_sistema);
        return Rol_SistemaMapper.DatosAlDTO(savedRol_Sistema);
     }

    @Override
    public Rol_SistemaDTO update(int id, Rol_SistemaDTO rol_SistemaDTO) {
        Rol_Sistema existingRol_Sistema = repositoryRol_Sistema.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Rol_Sistema no encontrado"));

// Actualiza los campos del proyecto con los datos del DTO
        // existingRol_Sistema.setNOMBRE(rol_SistemaDTO.getNOMBRE());



        Rol_Sistema updatedR = repositoryRol_Sistema.save(existingRol_Sistema);
        return Rol_SistemaMapper.DatosAlDTO(updatedR);    
    }

    @Override
    public void delete(int id) {
        Rol_Sistema RS = repositoryRol_Sistema.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Rol_Sistema no encontrado"));
    repositoryRol_Sistema.delete(RS);

     }

   
}
