package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Participante;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository("participanteRepository")

public interface RepositoryParticipante  extends JpaRepository<Participante,Integer>     {
      

    
}
