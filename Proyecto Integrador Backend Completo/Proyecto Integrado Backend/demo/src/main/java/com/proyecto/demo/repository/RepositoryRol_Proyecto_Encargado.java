package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Rol_Proyecto_Encargado;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository("rol_proyecto_encargadoRepository")

public interface RepositoryRol_Proyecto_Encargado  extends JpaRepository<Rol_Proyecto_Encargado,Integer>     {
      

    
}
