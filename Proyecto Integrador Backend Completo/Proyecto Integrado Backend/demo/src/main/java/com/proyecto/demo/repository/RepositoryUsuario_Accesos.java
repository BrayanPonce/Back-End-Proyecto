package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Usuario_Accesos;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository("usuario_accesosRepository")

public interface RepositoryUsuario_Accesos  extends JpaRepository<Usuario_Accesos,Integer>     {
      

    
}
