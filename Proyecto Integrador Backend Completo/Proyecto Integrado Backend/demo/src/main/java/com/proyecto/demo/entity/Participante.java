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

@Table(name = "PARTICIPANTE")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "participante_id_seq")
    @SequenceGenerator(name = "participante_id_seq", sequenceName = "participante_id_seq", allocationSize = 1)
    @Column(name = "ID_PARTICIPANTE")
    private int ID_PARTICIPANTE;


    @Column(name = "horas")
    private int horas;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROL_SISTEMA")
    private Rol_Sistema rol_sistema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DOCENTE")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESTUDIANTE")
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSONA")
   private Persona persona;
    

    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "ID_ROL_PROYECTO_ENCARGADO")
   private Rol_Proyecto_Encargado rol_proyecto_encargado;


   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "ID_PROYECTO")
   private Proyecto proyecto;

 
    
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "participante", cascade = CascadeType.ALL)
    List<Actividad_Participante> Actividad_Participante = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "participante", cascade = CascadeType.ALL)
    List<Encargado> encargado = new ArrayList<>();





}
