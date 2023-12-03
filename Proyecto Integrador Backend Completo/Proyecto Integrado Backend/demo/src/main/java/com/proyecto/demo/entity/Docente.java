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
@Table(name="DOCENTE")
public class Docente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docente_id_seq")
    @SequenceGenerator(name = "docente_id_seq", sequenceName = "docente_id_seq", allocationSize = 1)
    @Column(name="ID_DOCENTE")
    private int ID_DOCENTE;

    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "ID_PERSONA")
   private Persona persona;

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "docente", cascade = CascadeType.ALL)
    List<Participante> participante = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "docente", cascade = CascadeType.ALL)
    List<CursoArticulado> cursoarticulado = new ArrayList<>();




}
