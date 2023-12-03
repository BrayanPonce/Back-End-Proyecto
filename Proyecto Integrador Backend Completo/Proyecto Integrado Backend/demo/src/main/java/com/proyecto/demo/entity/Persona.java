package com.proyecto.demo.entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PERSONA")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_id_seq")
    @SequenceGenerator(name = "persona_id_seq", sequenceName = "persona_id_seq", allocationSize = 1)
    @Column(name="ID_PERSONA")
    private int ID_PERSONA;

     @Column(name="NOMBRE")
    private String NOMBRE;


    @Column(name="DNI")
    private String DNI;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROL_SISTEMA")
    private Rol_Sistema rol_sistema;



    @OneToOne(mappedBy = "personaR" ,cascade = CascadeType.ALL )
    private Usuario usuario;

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    List<Estudiante> estudiantes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    List<CursoArticulado> cursoarticulado = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    List<Participante> participante = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
    List<Docente> docente = new ArrayList<>();
    
 
}
