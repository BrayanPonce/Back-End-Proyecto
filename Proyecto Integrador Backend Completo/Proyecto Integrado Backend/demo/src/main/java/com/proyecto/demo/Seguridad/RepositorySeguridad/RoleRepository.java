package com.proyecto.demo.Seguridad.RepositorySeguridad;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Rol_Sistema;

@Repository

public interface RoleRepository extends CrudRepository<Rol_Sistema, Integer> {
    
}
