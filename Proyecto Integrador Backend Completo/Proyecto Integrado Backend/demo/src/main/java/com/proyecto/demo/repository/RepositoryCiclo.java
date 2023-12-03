package com.proyecto.demo.repository;
import com.proyecto.demo.entity.Ciclo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("cicloRepository")

public interface RepositoryCiclo  extends JpaRepository<Ciclo,Integer>     {
      

    
}
