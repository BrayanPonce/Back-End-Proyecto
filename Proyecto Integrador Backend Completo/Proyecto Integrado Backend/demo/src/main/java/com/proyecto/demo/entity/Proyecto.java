package com.proyecto.demo.entity;

import java.sql.Date;
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
@Table(name = "proyecto")
@AllArgsConstructor
@NoArgsConstructor
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proyecto_id_seq")
    @SequenceGenerator(name = "proyecto_id_seq", sequenceName = "proyecto_id_seq", allocationSize = 1)
    @Column(name = "ID_PROYECTO")
    private int ID_PROYECTO;


    @Column(name = "NOMBRE") 
    private String NOMBRE;

    @Column(name = "CODIGO") 
    private String CODIGO;

    @Column(name = "COORDINADOR")  
    private String COORDINADOR;

    @Column(name = "FECHA_INICIO")
    private Date FECHA_INICIO;

    @Column(name = "FECHA_FIN")
    private Date FECHA_FIN;
    
    @Column(name = "LUGAR")
    private String LUGAR;

    @Column(name = "OBJETIVOS")
    private String OBJETIVOS;

    @Column(name = "DESCRIPCION")
    private String DESCRIPCION;

    @Column(name = "PRESUPUESTO")
    private double PRESUPUESTO;

    @Column(name = "INFORME_FINAL")
    private String INFORME_FINAL;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SEMESTRE")    //Ya esta Gaaaaaaaaaaaaaa
    private Semestre semestre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESTADO") //Ya esta gaa :v
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_CONVENIO") //Ya esta gaa :v
    private Tipo_De_Convenio tipo_de_convenio; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESCUELA")   //Ya esta gaa :v
    private Escuela escuela;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CURSO_ARTICULADO") //Ya esta gaa :v
    private CursoArticulado cursoarticulado; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CICLO")    //Ya esta gaa :v
    private Ciclo ciclo;


     @OneToMany(fetch = FetchType.LAZY, mappedBy = "proyecto", cascade = CascadeType.ALL)
     List<Participante> participante = new ArrayList<>(); //Ready

     @OneToMany(fetch = FetchType.LAZY, mappedBy = "proyecto", cascade = CascadeType.ALL)
     List<Recurso> recurso= new ArrayList<>();  //Ya esta Gaaaaaaaaa

     @OneToMany(fetch = FetchType.LAZY, mappedBy = "proyecto", cascade = CascadeType.ALL)
     List<Actividad> actividad = new ArrayList<>(); //Listo

     @OneToMany(fetch = FetchType.LAZY, mappedBy = "proyecto", cascade = CascadeType.ALL)
     List<Rol_Proyecto> rol_proyecto = new ArrayList<>();

    

}
