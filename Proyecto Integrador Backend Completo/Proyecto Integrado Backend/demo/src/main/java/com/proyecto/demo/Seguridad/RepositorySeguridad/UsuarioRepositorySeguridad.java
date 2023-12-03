package com.proyecto.demo.Seguridad.RepositorySeguridad;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Usuario;

@Repository

public interface UsuarioRepositorySeguridad extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUSERNAME(String username);   

    @Query("select u from Usuario u where u.USERNAME = ?1")
    Optional<Usuario> getUSERNAME(String username);

    boolean existsByUSERNAME(String username);

   
}
