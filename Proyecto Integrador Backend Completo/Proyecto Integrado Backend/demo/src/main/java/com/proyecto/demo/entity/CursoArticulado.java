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
@Table(name = "CURSO_ARTICULADO")
@AllArgsConstructor
@NoArgsConstructor
public class CursoArticulado {

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_articulado_id_seq")
    @SequenceGenerator(name = "curso_articulado_id_seq", sequenceName = "curso_articulado_id_seq", allocationSize = 1)
    @Column(name = "ID_CURSO_ARTICULADO")
    private int ID_CURSO_ARTICULADO;

    @Column(name = "NOMBRE")
    private String NOMBRE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESCUELA")
    private Escuela escuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSONA")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DOCENTE")
    private Docente docente;

     

   
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cursoarticulado", cascade = CascadeType.ALL)
    List<Proyecto> proyecto = new ArrayList<>();
    
}
