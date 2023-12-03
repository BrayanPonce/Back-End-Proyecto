package com.proyecto.demo.repository;
import com.proyecto.demo.entity.Actividad_Participante;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("actividad_participanteRepository")

public interface RepositoryActividad_Participante extends JpaRepository<Actividad_Participante,Integer>     {
    



    
}
