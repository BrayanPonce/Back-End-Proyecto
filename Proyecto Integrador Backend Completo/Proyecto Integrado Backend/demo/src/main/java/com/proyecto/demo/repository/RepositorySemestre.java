package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Semestre;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("semestreRepository")

public interface RepositorySemestre  extends JpaRepository<Semestre,Integer>     {
      

    
}
