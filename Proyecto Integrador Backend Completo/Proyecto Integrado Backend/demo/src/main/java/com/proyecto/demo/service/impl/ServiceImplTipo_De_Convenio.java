package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.Tipo_De_ConvenioDTO;
import com.proyecto.demo.Mapper.Tipo_De_ConvenioMapper;
import com.proyecto.demo.entity.Tipo_De_Convenio;
import com.proyecto.demo.repository.RepositoryTipo_De_Convenio;
import com.proyecto.demo.service.ServiceTipo_De_Convenio;

import jakarta.transaction.Transactional;


@Service("tipo_de_convenioServiceImpl")
@Transactional

public class ServiceImplTipo_De_Convenio implements ServiceTipo_De_Convenio  {
   
    @Autowired
    @Qualifier("tipo_de_convenioRepository")
    private RepositoryTipo_De_Convenio repositoryTipo_De_Convenio;

    @Override
    public List<Tipo_De_ConvenioDTO> getAll() {
           List<Tipo_De_Convenio> proyectos = repositoryTipo_De_Convenio.findAll();
        return proyectos.stream()
                .map(Tipo_De_ConvenioMapper::DatosAlDTO)
                .collect(Collectors.toList());
  }

    @Override
    public Tipo_De_ConvenioDTO getById(int id) {
        Tipo_De_Convenio tipo_De_Convenio = repositoryTipo_De_Convenio.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Tipo_De_Convenio no encontrado"));
    return Tipo_De_ConvenioMapper.DatosAlDTO(tipo_De_Convenio);
     }

    @Override
    public Tipo_De_ConvenioDTO create(Tipo_De_ConvenioDTO tipo_De_ConvenioDTO) {
        Tipo_De_Convenio tipo_De_Convenio = Tipo_De_ConvenioMapper.DatosAlaEdentidad(tipo_De_ConvenioDTO);
        Tipo_De_Convenio savedtipo_De_Convenio = repositoryTipo_De_Convenio.save(tipo_De_Convenio);
        return Tipo_De_ConvenioMapper.DatosAlDTO(savedtipo_De_Convenio);
     }

    @Override
    public Tipo_De_ConvenioDTO update(int id, Tipo_De_ConvenioDTO tipo_De_ConvenioDTO) {
        Tipo_De_Convenio existingTipo_De_Convenio = repositoryTipo_De_Convenio.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Tipo_De_Convenio no encontrado"));

     // Actualiza los campos del proyecto con los datos del DTO
     existingTipo_De_Convenio.setNOMBRE(tipo_De_ConvenioDTO.getNOMBRE());

        Tipo_De_Convenio updatedTipo_De_Convenio = repositoryTipo_De_Convenio.save(existingTipo_De_Convenio);
     return Tipo_De_ConvenioMapper.DatosAlDTO(updatedTipo_De_Convenio);    
  }

    @Override
    public void delete(int id) {
        Tipo_De_Convenio tipo_De_Convenio = repositoryTipo_De_Convenio.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("tipo_De_Convenio no encontrado"));
repositoryTipo_De_Convenio.delete(tipo_De_Convenio);

}

    
}
