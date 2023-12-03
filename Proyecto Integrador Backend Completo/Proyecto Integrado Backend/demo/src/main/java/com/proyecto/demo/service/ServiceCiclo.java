package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.CicloDTO;

public interface ServiceCiclo {

        List<CicloDTO> getAllCiclo();
    CicloDTO getCicloById(int id);
    CicloDTO createCiclo(CicloDTO cicloDTO);
    CicloDTO updateCiclo(int id, CicloDTO cicloDTO);
    void deletCicloo(int id);


    
}
