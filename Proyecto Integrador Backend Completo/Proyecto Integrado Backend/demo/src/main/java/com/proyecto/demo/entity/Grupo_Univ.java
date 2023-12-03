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
@Table(name="GRUPO_UNIV")
public class Grupo_Univ {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_univ_id_seq")
    @SequenceGenerator(name = "grupo_univ_id_seq", sequenceName = "grupo_univ_id_seq", allocationSize = 1)
    @Column(name="ID_GRUPO_UNIV")
    private int ID_GRUPO_UNIV;

     @Column(name="NOMBRE")
    private String NOMBRE;

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo_univ", cascade = CascadeType.ALL)
    List<Estudiante> estudiantes = new ArrayList<>();



}
