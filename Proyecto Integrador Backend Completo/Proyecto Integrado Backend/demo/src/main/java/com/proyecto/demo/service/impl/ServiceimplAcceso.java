package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.AccesoDTO;
import com.proyecto.demo.Mapper.AccesoMapper;
import com.proyecto.demo.entity.Acceso;
import com.proyecto.demo.repository.RepositoryAcceso;
import com.proyecto.demo.service.ServiceAcceso;

import jakarta.transaction.Transactional;

@Transactional
@Service("accesoServiceImpl")

public class ServiceimplAcceso implements ServiceAcceso {


    @Autowired
    @Qualifier("accesoRepository")
    private RepositoryAcceso repositoryAcceso;

    @Override
    public List<AccesoDTO> getAll() {
        List<Acceso> var = repositoryAcceso.findAll();  

        return var.stream().map(AccesoMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public AccesoDTO getById(int id) {
        Acceso var = repositoryAcceso.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("acceso no encontrado"));
    return AccesoMapper.DatosAlDTO(var);
    }

    @Override
    public AccesoDTO create(AccesoDTO accesoDTO) {
        Acceso var = AccesoMapper.DatosAlaEdentidad(accesoDTO);
        Acceso var2 = repositoryAcceso.save(var);
        return AccesoMapper.DatosAlDTO(var2);
    }

    @Override
    public AccesoDTO update(int id, AccesoDTO accesoDTO) {
        Acceso existingVar = repositoryAcceso.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("acceso no encontrado"));

// Actualiza los campos del proyecto con los datos del DTO
        existingVar.setNOMBRE(accesoDTO.getNOMBRE());
        existingVar.setURL(accesoDTO.getURL());
        existingVar.setID_ACCESOS_PADRE(accesoDTO.getID_ACCESOS_PADRE());

        Acceso updatedVar = repositoryAcceso.save(existingVar);
        return AccesoMapper.DatosAlDTO(updatedVar);    
   }

    @Override
    public void delete(int id) {
           Acceso var = repositoryAcceso.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("acceso no encontrado"));
    repositoryAcceso.delete(var);

   }

   
     
}
