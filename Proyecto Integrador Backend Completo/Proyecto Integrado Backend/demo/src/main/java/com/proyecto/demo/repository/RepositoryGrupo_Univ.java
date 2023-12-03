package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Grupo_Univ;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository("grupo_univRepository")

public interface RepositoryGrupo_Univ  extends JpaRepository<Grupo_Univ,Integer>     {
      

    
}
