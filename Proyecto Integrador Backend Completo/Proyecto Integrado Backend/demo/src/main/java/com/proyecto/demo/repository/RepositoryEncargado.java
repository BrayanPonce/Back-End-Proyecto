package com.proyecto.demo.repository;
import com.proyecto.demo.entity.Encargado;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("encargadoRepository")

public interface RepositoryEncargado  extends JpaRepository<Encargado,Integer>     {
      

    
}
