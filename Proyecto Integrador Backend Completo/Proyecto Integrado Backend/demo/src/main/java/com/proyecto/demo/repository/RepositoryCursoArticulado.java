package com.proyecto.demo.repository;
import com.proyecto.demo.entity.CursoArticulado;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("cursoarticuladoRepository")

public interface RepositoryCursoArticulado  extends JpaRepository<CursoArticulado,Integer>     {
      

    
}
