package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.DTO.PlantillaDTO;
import com.proyecto.demo.Mapper.PlantillaMapper;
import com.proyecto.demo.entity.Plantilla;
import com.proyecto.demo.entity.Tipo_De_Convenio;
import com.proyecto.demo.repository.RepositoryPlantilla;
import com.proyecto.demo.repository.RepositoryTipo_De_Convenio;
import com.proyecto.demo.service.ServicePlantilla;

import jakarta.transaction.Transactional;

@Transactional
@Service("plantillaServiceImpl")


public class ServiceImplPlantilla implements ServicePlantilla {
    @Autowired
    @Qualifier("plantillaRepository")
    private RepositoryPlantilla repositoryPlantilla;


    @Autowired
    @Qualifier("tipo_de_convenioRepository")
    private RepositoryTipo_De_Convenio repositoryTipo_De_Convenio;

    @Override
    public List<PlantillaDTO> getAll() {
        List<Plantilla> var = repositoryPlantilla.findAll();  

        return var.stream().map(PlantillaMapper::DatosAlDTO).collect(Collectors.toList());
   }

    @Override
    public PlantillaDTO getById(int id) {
         Plantilla var = repositoryPlantilla.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Plantilla no encontrado"));
    return PlantillaMapper.DatosAlDTO(var);
    }

    @Override
    public PlantillaDTO create(PlantillaDTO plantillaDTO) {
        Plantilla var = PlantillaMapper.DatosAlaEdentidad(plantillaDTO);
        Plantilla var2 = repositoryPlantilla.save(var);
        return PlantillaMapper.DatosAlDTO(var2);
    }

    @Override
    public PlantillaDTO update(int id, PlantillaDTO plantillaDTO) {
        Plantilla existingVar = repositoryPlantilla.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Plantilla no encontrado"));

// Actualiza los campos del proyecto con los datos del DTO
        existingVar.setNOMBRE(plantillaDTO.getNOMBRE());
        existingVar.setURL(plantillaDTO.getURL());

    //Lo de Abajo Son para editar a los Ids que Jala, al momento de agregar si no envia alguna solicitud
    //lo capta como null, para despues editarlo

    //----------------------------------------------------------------------------------- Proyecto
    if (plantillaDTO.getID_TIPO_DE_CONVENIO() != null) {
        // Comprueba si el Semestre tiene un ID_PROYECTO válido
        if (plantillaDTO.getID_TIPO_DE_CONVENIO().getID_TIPO_DE_CONVENIO() != 0) {
            // Busca y asigna el objeto Proyecto existente basado en el ID proporcionado
            Tipo_De_Convenio tipo_de_convenio = repositoryTipo_De_Convenio.findById(plantillaDTO.getID_TIPO_DE_CONVENIO().getID_TIPO_DE_CONVENIO())
                    .orElseThrow(() -> new PropertyNotFoundException("Tipo de convenio no encontrado"));
            existingVar.setTipo_de_convenio(tipo_de_convenio);
        } else {
            // Maneja el caso en el que no se proporciona un nuevo Proyecto
            existingVar.setTipo_de_convenio(null);
        }
    }


        Plantilla updatedVar = repositoryPlantilla.save(existingVar);
        return PlantillaMapper.DatosAlDTO(updatedVar);    
   }

    @Override
    public void delete(int id) {
        Plantilla var = repositoryPlantilla.findById(id)
        .orElseThrow(() -> new PropertyNotFoundException("Estado no encontrado"));
    repositoryPlantilla.delete(var);

   }

  
}
