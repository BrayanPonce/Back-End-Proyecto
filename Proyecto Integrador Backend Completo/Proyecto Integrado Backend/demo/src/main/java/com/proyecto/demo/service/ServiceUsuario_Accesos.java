package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.Usuario_AccesosDTO;

public interface ServiceUsuario_Accesos {

   List<Usuario_AccesosDTO> getAll();
    Usuario_AccesosDTO getById(int id);
    Usuario_AccesosDTO create(Usuario_AccesosDTO usuario_accesosDTO);
    Usuario_AccesosDTO update(int id, Usuario_AccesosDTO usuario_accesosDTO);
    void delete(int id);



    
}
