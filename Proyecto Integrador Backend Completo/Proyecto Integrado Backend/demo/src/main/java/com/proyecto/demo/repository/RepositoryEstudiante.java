package com.proyecto.demo.repository;
import com.proyecto.demo.entity.Estudiante;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("estudianteRepository")

public interface RepositoryEstudiante  extends JpaRepository<Estudiante,Integer>     {
      

    
}
