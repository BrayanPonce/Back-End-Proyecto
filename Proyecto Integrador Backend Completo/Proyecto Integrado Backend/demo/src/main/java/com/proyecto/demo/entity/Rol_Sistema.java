package com.proyecto.demo.entity;



import java.util.ArrayList;
import java.util.List;

import com.proyecto.demo.Seguridad.Enum.ERole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "ROL_SISTEMA")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rol_Sistema {

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_sistema_id_seq")
    @SequenceGenerator(name = "rol_sistema_id_seq", sequenceName = "rol_sistema_id_seq", allocationSize = 1)   
    @Column(name = "ID_ROL_SISTEMA")
    private int ID_ROL_SISTEMA;

    @Column(name = "NOMBRE")
    @Enumerated(EnumType.STRING)
    private ERole NOMBRE;
  
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol_sistema", cascade = CascadeType.ALL)
    List<Participante> participante = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol_sistema", cascade = CascadeType.ALL)
    List<Persona> persona = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol_sistema", cascade = CascadeType.ALL)
    List<Rol_Sistema_Accesos> rol_sistema_accesos = new ArrayList<>();

    

}
