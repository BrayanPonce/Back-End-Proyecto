package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.CicloDTO;
import com.proyecto.demo.Mapper.CicloMapper;
import com.proyecto.demo.entity.Ciclo;
import com.proyecto.demo.entity.Escuela;
import com.proyecto.demo.repository.RepositoryCiclo;
import com.proyecto.demo.repository.RepositoryEscuela;
import com.proyecto.demo.service.ServiceCiclo;

import jakarta.transaction.Transactional;


@Transactional
@Service("cicloServiceImpl")


public class ServiceImplCiclo implements ServiceCiclo {

    @Autowired
    @Qualifier("cicloRepository")
    private RepositoryCiclo repositoryCiclo;

    @Autowired
    @Qualifier("escuelaRepository")
    private RepositoryEscuela repositoryEscuela;

    @Override
    public List<CicloDTO> getAllCiclo() {
       List<Ciclo> ciclo = repositoryCiclo.findAll();  

        return ciclo.stream().map(CicloMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public CicloDTO getCicloById(int id) {
      Ciclo ciclo = repositoryCiclo.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Ciclo no encontrado"));
    return CicloMapper.DatosAlDTO(ciclo);
     }

    @Override
    public CicloDTO createCiclo(CicloDTO cicloDTO) {
        Ciclo ciclo = CicloMapper.DatosAlaEdentidad(cicloDTO);
        Ciclo savedciclo = repositoryCiclo.save(ciclo);
        return CicloMapper.DatosAlDTO(savedciclo);
     }

    @Override
    public CicloDTO updateCiclo(int id, CicloDTO cicloDTO) {
        Ciclo existingCiclo = repositoryCiclo.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Ciclo no encontrado"));

// Actualiza los campos del proyecto con los datos del DTO
        existingCiclo.setNOMBRE(cicloDTO.getNOMBRE());

          //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Proyecto
    if (cicloDTO.getID_ESCUELA() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (cicloDTO.getID_ESCUELA().getID_ESCUELA() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Escuela escuela = repositoryEscuela.findById(cicloDTO.getID_ESCUELA().getID_ESCUELA())
                    .orElseThrow(() -> new PropertyNotFoundException ("Escuela no encontrado"));
            existingCiclo.setEscuela(escuela);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingCiclo.setEscuela(null);
        }
    }




        Ciclo updatedCiclo = repositoryCiclo.save(existingCiclo);
        return CicloMapper.DatosAlDTO(updatedCiclo);    
    }

    @Override
    public void deletCicloo(int id) {
        Ciclo ciclo = repositoryCiclo.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estado no encontrado"));
    repositoryCiclo.delete(ciclo);
 }


    
}
