package com.proyecto.demo.Seguridad.Requets;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateUserDTO {

    @NotBlank
    private String username;


    @NotBlank
    private String password;

    
    private Set<String> roles;
    
}
