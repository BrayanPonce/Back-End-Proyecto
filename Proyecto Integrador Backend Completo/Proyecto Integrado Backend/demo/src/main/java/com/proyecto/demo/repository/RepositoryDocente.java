package com.proyecto.demo.repository;
import com.proyecto.demo.entity.Docente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("docenteRepository")

public interface RepositoryDocente  extends JpaRepository<Docente,Integer>     {
      

    
}
