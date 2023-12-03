package com.proyecto.demo.repository;
import com.proyecto.demo.entity.Proyecto;


import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("proyectoRepository")

public interface RepositoryProyecto  extends JpaRepository <Proyecto,Integer> {
    List<Proyecto> findByNOMBRE(String nombre);
    
}
