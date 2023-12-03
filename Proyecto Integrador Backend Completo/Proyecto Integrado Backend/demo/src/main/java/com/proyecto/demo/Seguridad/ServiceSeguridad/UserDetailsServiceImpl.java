package com.proyecto.demo.Seguridad.ServiceSeguridad;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyecto.demo.Seguridad.RepositorySeguridad.UsuarioRepositorySeguridad;
import com.proyecto.demo.entity.Usuario;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepositorySeguridad usuarioRepositorySeguridad;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
        Usuario usuario = usuarioRepositorySeguridad.findByUSERNAME(username)
        .orElseThrow(() -> new UsernameNotFoundException("El Usuario" + username + "No existe"));


        Collection<? extends GrantedAuthority> authorities = usuario.getRoles().stream().map(
            roles -> new SimpleGrantedAuthority("ROLE_".concat(roles.getNOMBRE().name()))
        ).collect(Collectors.toSet());



        return new User(usuario.getUSERNAME(),
        usuario.getPASSWORD(),
        true,
        true,
        true,
        true,
        authorities);
    }
    
}
