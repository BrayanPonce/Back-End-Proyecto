package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.SemestreDTO;
import com.proyecto.demo.Mapper.SemestreMapper;
import com.proyecto.demo.entity.Semestre;
import com.proyecto.demo.repository.RepositorySemestre;
import com.proyecto.demo.service.ServiceSemestre;

import jakarta.transaction.Transactional;

@Service("semestreServiceImpl")
@Transactional

public class ServiceImplSemestre implements ServiceSemestre{

    @Autowired
    @Qualifier("semestreRepository")
    private RepositorySemestre repositorySemestre;

    



    @Override
    public List<SemestreDTO> getAllSemestre() {
   
        List<Semestre> semestre = repositorySemestre.findAll();
        return semestre.stream().map(SemestreMapper::SemestreADTO).collect(Collectors.toList());
   
   
    }


    @Override
    public SemestreDTO getSemestreById(int id) {
        Semestre semestre = repositorySemestre.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Semestre no encontrado"));

        return SemestreMapper.SemestreADTO(semestre);


     }


    @Override
    public SemestreDTO createSemestre(SemestreDTO semestreDTO) { 
       Semestre semestre = SemestreMapper.DTOASemestre(semestreDTO);
       Semestre savedSemestre = repositorySemestre.save(semestre);
       return SemestreMapper.SemestreADTO(savedSemestre); 
 
    }


    @Override
    public SemestreDTO updateSemestre(int id, SemestreDTO semestreDTO) {
        Semestre existingSemestre = repositorySemestre.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Semestre no encontrado"));

        existingSemestre.setNOMBRE(semestreDTO.getNOMBRE());

        Semestre updatedSemestre = repositorySemestre.save(existingSemestre);
        return SemestreMapper.SemestreADTO(updatedSemestre);

    }


    @Override
    public void deleteSemestre(int id) {
         Semestre semestre = repositorySemestre.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Semestre no encontrado"));
    repositorySemestre.delete(semestre);

   }


    @Override
    public List<SemestreDTO> getSemestrePorNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSemestrePorNombre'");
    }


    

    
}
