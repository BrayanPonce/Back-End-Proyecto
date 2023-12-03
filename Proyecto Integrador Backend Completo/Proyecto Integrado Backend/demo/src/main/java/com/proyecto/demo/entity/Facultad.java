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
@Table(name="FACULTAD")
public class Facultad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facultad_id_seq")
    @SequenceGenerator(name = "facultad_id_seq", sequenceName = "facultad_id_seq", allocationSize = 1)
    @Column(name="ID_FACULTAD")
    private int ID_FACULTAD;


    @Column(name="NOMBRE")
    private String NOMBRE;

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "FACULTAD", cascade = CascadeType.ALL)
    List<Escuela> escuela = new ArrayList<>();



}
