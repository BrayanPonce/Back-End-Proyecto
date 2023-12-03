package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.Grupo_UnivDTO;
import com.proyecto.demo.Mapper.Grupo_UnivMapper;
import com.proyecto.demo.entity.Grupo_Univ;
import com.proyecto.demo.repository.RepositoryGrupo_Univ;
import com.proyecto.demo.service.ServiceGrupo_Univ;

import jakarta.transaction.Transactional;

@Transactional
@Service("grupo_univServiceImpl")

public class ServiceImplGrupo_univ implements ServiceGrupo_Univ {
    

    @Autowired
    @Qualifier("grupo_univRepository")
    private RepositoryGrupo_Univ repositoryGrupo_Univ;

    @Override
    public List<Grupo_UnivDTO> getAll() {
         List<Grupo_Univ> var = repositoryGrupo_Univ.findAll();  

        return var.stream().map(Grupo_UnivMapper::DatosAlDTO).collect(Collectors.toList());
    }

    @Override
    public Grupo_UnivDTO getById(int id) {
         Grupo_Univ var = repositoryGrupo_Univ.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Grupo_Univ no encontrado"));
    return Grupo_UnivMapper.DatosAlDTO(var);
    }

    @Override
    public Grupo_UnivDTO create(Grupo_UnivDTO grupo_UnivDTO) {
        Grupo_Univ var = Grupo_UnivMapper.DatosAlaEdentidad(grupo_UnivDTO);
        Grupo_Univ var2 = repositoryGrupo_Univ.save(var);
        return Grupo_UnivMapper.DatosAlDTO(var2);
    }

    @Override
    public Grupo_UnivDTO update(int id, Grupo_UnivDTO grupo_UnivDTO) {
        Grupo_Univ existingVar = repositoryGrupo_Univ.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Grupo_Univ no encontrado"));

// Actualiza los campos del proyecto con los datos del DTO
        existingVar.setNOMBRE(grupo_UnivDTO.getNOMBRE());
        

        Grupo_Univ updatedVar = repositoryGrupo_Univ.save(existingVar);
        return Grupo_UnivMapper.DatosAlDTO(updatedVar);    
   }

    @Override
    public void delete(int id) {
        Grupo_Univ var = repositoryGrupo_Univ.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estado no encontrado"));
    repositoryGrupo_Univ.delete(var);

   }

  
     
}
