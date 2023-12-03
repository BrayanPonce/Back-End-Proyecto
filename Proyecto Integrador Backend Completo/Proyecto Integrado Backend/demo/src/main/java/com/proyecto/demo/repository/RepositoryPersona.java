package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Persona;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository("personaRepository")

public interface RepositoryPersona  extends JpaRepository<Persona,Integer>     {
      

    
}
