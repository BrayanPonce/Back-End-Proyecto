package com.proyecto.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="SEMESTRE")
public class Semestre {
    
    @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "semestre_id_seq")
    @SequenceGenerator(name = "semestre_id_seq", sequenceName = "semestre_id_seq", allocationSize = 1)   
    @Column(name="ID_Semestre")
    private int ID_SEMESTRE;

    @Column(name="NOMBRE")
    private String NOMBRE;

    
    @OneToMany( mappedBy = "semestre", cascade = CascadeType.ALL)
    List<Proyecto> proyecto = new ArrayList<>();



}
