package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Rol_Proyecto;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository("rol_proyectoRepository")

public interface RepositoryRol_Proyecto  extends JpaRepository<Rol_Proyecto,Integer>     {
      

    
}
