package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Rol_Sistema_Accesos;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("rol_sistema_accesosRepository")

public interface RepositoryRol_Sistema_Accesos  extends JpaRepository<Rol_Sistema_Accesos,Integer>     {
      

    
}
