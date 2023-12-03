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
@Table(name = "CICLO")
@AllArgsConstructor
@NoArgsConstructor
public class Ciclo {

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciclo_id_seq")
    @SequenceGenerator(name = "ciclo_id_seq", sequenceName = "ciclo_id_seq", allocationSize = 1)  
    @Column(name = "ID_CICLO")
    private int ID_CICLO;

    @Column(name = "NOMBRE")
    private String NOMBRE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESCUELA")
    private Escuela escuela;

     

   
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ciclo", cascade = CascadeType.ALL)
    List<Proyecto> proyecto = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ciclo", cascade = CascadeType.ALL)
    List<Estudiante> estudiante = new ArrayList<>();
    
}
