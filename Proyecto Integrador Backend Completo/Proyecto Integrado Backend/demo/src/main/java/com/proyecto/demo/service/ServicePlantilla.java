package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.PlantillaDTO;

public interface ServicePlantilla {

   List<PlantillaDTO> getAll();
    PlantillaDTO getById(int id);
    PlantillaDTO create(PlantillaDTO plantillaDTO);
    PlantillaDTO update(int id, PlantillaDTO plantillaDTO);
    void delete(int id);



    
}
