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
@Table(name = "ACTIVIDAD")
@AllArgsConstructor
@NoArgsConstructor
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actividad_id_seq")
    @SequenceGenerator(name = "actividad_id_seq", sequenceName = "actividad_id_seq", allocationSize = 1)
    @Column(name = "ID_ACTIVIDAD")
    private int ID_ACTIVIDAD;

   
    @Column(name = "NOMBRE")
    private String NOMBRE;

   
    @Column(name = "FECHA")
    private Date FECHA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PROYECTO")
    private Proyecto proyecto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ENCARGADO")
    private Encargado encargado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "actividad", cascade = CascadeType.ALL)
    List<Actividad_Participante> Actividad_Participante = new ArrayList<>();





}
