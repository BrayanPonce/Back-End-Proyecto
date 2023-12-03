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
@Table(name="ESTUDIANTE")
public class Estudiante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiante_id_seq")
    @SequenceGenerator(name = "estudiante_id_seq", sequenceName = "estudiante_id_seq", allocationSize = 1)
    @Column(name="ID_ESTUDIANTE")
    private int ID_ESTUDIANTE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSONA")
    private Persona persona;

     @Column(name="CODIGO")
    private String CODIGO;

     @Column(name="HORAS_TOTALES")
    private int HORAS_TOTALES;

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_GRUPO_UNIV")
    private Grupo_Univ grupo_univ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CICLO")
    private Ciclo ciclo;

     

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante", cascade = CascadeType.ALL)
    List<Participante> participante = new ArrayList<>();



}
