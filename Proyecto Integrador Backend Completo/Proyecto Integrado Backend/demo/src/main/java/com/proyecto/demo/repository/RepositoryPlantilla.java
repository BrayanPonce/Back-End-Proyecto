package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Plantilla;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository("plantillaRepository")

public interface RepositoryPlantilla  extends JpaRepository<Plantilla,Integer>     {
      

    
}
