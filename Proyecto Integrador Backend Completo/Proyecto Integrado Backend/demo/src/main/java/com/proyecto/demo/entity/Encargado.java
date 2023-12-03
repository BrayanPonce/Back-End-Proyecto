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
@Table(name = "ENCARGADO")
@AllArgsConstructor
@NoArgsConstructor
public class Encargado {

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "encargado_id_seq")
    @SequenceGenerator(name = "encargado_id_seq", sequenceName = "encargado_id_seq", allocationSize = 1)   
    @Column(name = "ID_ENCARGADO")
    private int ID_ENCARGADO;

    @Column(name = "NOMBRE")
    private String NOMBRE;

    @Column(name = "ROL")
    private String ROL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PARTICIPANTE")
    private Participante participante;


   @OneToMany(fetch = FetchType.LAZY, mappedBy = "encargado", cascade = CascadeType.ALL)
    List<Rol_Proyecto_Encargado> rol_proyecto_encargado = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "encargado", cascade = CascadeType.ALL)
    List<Actividad> actividad = new ArrayList<>();
    
}
