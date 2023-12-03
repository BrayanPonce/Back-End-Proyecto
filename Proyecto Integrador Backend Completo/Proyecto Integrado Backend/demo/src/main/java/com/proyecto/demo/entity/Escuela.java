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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ESCUELA")
public class Escuela {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "escuela_id_seq")
    @SequenceGenerator(name = "escuela_id_seq", sequenceName = "escuela_id_seq", allocationSize = 1)
    @Column(name="ID_ESCUELA")
    private int ID_ESCUELA;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Facultad")
    private Facultad FACULTAD;


    @Column(name="NOMBRE")
    private String NOMBRE;

    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "escuela", cascade = CascadeType.ALL)
    List<Proyecto> proyecto = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "escuela", cascade = CascadeType.ALL)
    List<Ciclo> ciclo = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "escuela", cascade = CascadeType.ALL)
    List<CursoArticulado> cursoarticulado = new ArrayList<>();


}
