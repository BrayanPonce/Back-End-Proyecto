package com.proyecto.demo.repository;

import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Tipo_De_Convenio;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("tipo_de_convenioRepository")

public interface RepositoryTipo_De_Convenio  extends JpaRepository<Tipo_De_Convenio,Integer>     {
      

    
}
