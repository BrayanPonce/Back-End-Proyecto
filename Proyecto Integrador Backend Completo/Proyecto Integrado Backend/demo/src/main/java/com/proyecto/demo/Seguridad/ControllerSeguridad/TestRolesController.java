package com.proyecto.demo.Seguridad.ControllerSeguridad;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestRolesController {



    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accesAdmin(){


        return "si funciona para admin";
    }

    @GetMapping("/docente")
    @PreAuthorize("hasAnyRole('DOCENTE','ADMIN') ")
    public String accesDocente(){


        return "si funciona para Docente";
    }

    @GetMapping("/estudiante")
    // @PreAuthorize("hasRole('ESTUDIANTE')")
    public String accesestudiante(){


        return "si funciona para estudiante";
    }
    
}
