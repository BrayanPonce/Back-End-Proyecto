package com.proyecto.demo.repository;
import com.proyecto.demo.entity.Acceso;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("accesoRepository")

public interface RepositoryAcceso  extends JpaRepository<Acceso,Integer>     {
     
}
