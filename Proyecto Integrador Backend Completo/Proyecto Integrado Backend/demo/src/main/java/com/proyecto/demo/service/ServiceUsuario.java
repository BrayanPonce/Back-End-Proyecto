package com.proyecto.demo.service;

import java.util.List;
import com.proyecto.demo.DTO.UsuarioDTO;

public interface ServiceUsuario {

    List<UsuarioDTO> getAll();
    UsuarioDTO getById(int id);
    UsuarioDTO create(UsuarioDTO usuarioDTO);
    UsuarioDTO update(int id, UsuarioDTO usuarioDTO);
    void delete(int id);



    
}
