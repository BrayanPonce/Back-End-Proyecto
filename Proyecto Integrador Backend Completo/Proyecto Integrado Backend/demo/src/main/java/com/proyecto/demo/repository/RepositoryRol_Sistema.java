package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Rol_Sistema;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("rol_sistemaRepository")

public interface RepositoryRol_Sistema  extends JpaRepository<Rol_Sistema,Integer>     {
      

    
}
