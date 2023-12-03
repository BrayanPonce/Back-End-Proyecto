package com.proyecto.demo.repository;
import com.proyecto.demo.entity.Actividad;
import org.springframework.stereotype.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

@Repository("actividadRepository")

public interface RepositoryActividad extends JpaRepository<Actividad,Integer>     {

    @Query("SELECT a FROM Actividad a WHERE a.NOMBRE = :nombre")
Optional<Actividad> findByNombre(@Param("nombre") String nombre);



    
}
