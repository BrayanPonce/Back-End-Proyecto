package com.proyecto.demo.repository;
import com.proyecto.demo.entity.Facultad;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("facultadRepository")

public interface RepositoryFacultad  extends JpaRepository<Facultad,Integer>     {
      

    
}
