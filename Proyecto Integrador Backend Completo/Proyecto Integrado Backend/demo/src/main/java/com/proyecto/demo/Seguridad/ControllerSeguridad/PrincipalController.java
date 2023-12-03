package com.proyecto.demo.Seguridad.ControllerSeguridad;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.demo.Seguridad.Enum.ERole;
import com.proyecto.demo.Seguridad.RepositorySeguridad.UsuarioRepositorySeguridad;
import com.proyecto.demo.Seguridad.Requets.CreateUserDTO;
import com.proyecto.demo.entity.Rol_Sistema;
import com.proyecto.demo.entity.Usuario;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/main")

public class PrincipalController {


    @Autowired
    private PasswordEncoder passwordEncoder;
    
   @Autowired 
    private UsuarioRepositorySeguridad usuarioRepositorySeguridad;



 @PostMapping("/crear")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
    // Verificar si el nombre de usuario ya existe en la base de datos
    if (usuarioRepositorySeguridad.existsByUSERNAME(createUserDTO.getUsername())) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("El nombre de usuario ya existe. Por favor, elige otro nombre reconcxatumale hdpolsd gaaaaaaaaa.");
    }

    Set<Rol_Sistema> roles = createUserDTO.getRoles().stream()
            .map(role -> Rol_Sistema.builder()
                    .NOMBRE(ERole.valueOf(role))
                    .build())
            .collect(Collectors.toSet());

    Usuario usuario = Usuario.builder()
            .USERNAME(createUserDTO.getUsername())
            .PASSWORD(passwordEncoder.encode(createUserDTO.getPassword()))
            .roles(roles)
            .build();

    usuarioRepositorySeguridad.save(usuario);

    return ResponseEntity.ok(usuario);
}

}
