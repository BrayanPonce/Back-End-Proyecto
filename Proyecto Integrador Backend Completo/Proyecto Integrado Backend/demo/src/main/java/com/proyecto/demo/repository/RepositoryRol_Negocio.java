package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Rol_Negocio;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository("rol_negocioRepository")

public interface RepositoryRol_Negocio  extends JpaRepository<Rol_Negocio,Integer>     {
      

    
}
