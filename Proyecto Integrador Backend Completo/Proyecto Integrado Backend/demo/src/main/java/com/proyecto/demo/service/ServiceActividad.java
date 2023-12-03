package com.proyecto.demo.service;

import java.util.List;

import com.proyecto.demo.DTO.ActividadesDTO;


public interface ServiceActividad {

       List<ActividadesDTO> getAll();
    ActividadesDTO getById(int id);
    ActividadesDTO create(ActividadesDTO actividadDTO);
    ActividadesDTO update(int id, ActividadesDTO actividadDTO);
    void delete(int id);



    
}