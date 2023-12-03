package com.proyecto.demo.repository;
import com.proyecto.demo.entity.Escuela;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("escuelaRepository")

public interface RepositoryEscuela  extends JpaRepository<Escuela,Integer>     {
      

    
}
