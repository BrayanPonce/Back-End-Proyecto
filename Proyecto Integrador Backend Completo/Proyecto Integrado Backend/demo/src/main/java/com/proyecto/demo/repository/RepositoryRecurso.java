package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Recurso;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository("recursoRepository")

public interface RepositoryRecurso  extends JpaRepository<Recurso,Integer>     {
      

    
}
