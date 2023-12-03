package com.proyecto.demo.repository;
import com.proyecto.demo.entity.Estado;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("estadoRepository")

public interface RepositoryEstado  extends JpaRepository<Estado,Integer>     {
      

    
}
