package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.Tipo_De_ConvenioDTO;

public interface ServiceTipo_De_Convenio {

   List<Tipo_De_ConvenioDTO> getAll();
    Tipo_De_ConvenioDTO getById(int id);
    Tipo_De_ConvenioDTO create(Tipo_De_ConvenioDTO tipo_De_ConvenioDTO);
    Tipo_De_ConvenioDTO update(int id, Tipo_De_ConvenioDTO tipo_De_ConvenioDTO);
    void delete(int id);



    
}
