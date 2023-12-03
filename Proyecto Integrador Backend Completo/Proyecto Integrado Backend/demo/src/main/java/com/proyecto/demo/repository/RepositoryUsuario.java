package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository("usuarioRepository")

public interface RepositoryUsuario  extends JpaRepository<Usuario,Integer>     {
      

    
}
