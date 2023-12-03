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
@Table(name="TIPO_DE_CONVENIO")
public class Tipo_De_Convenio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_de_convenio_id_seq")
    @SequenceGenerator(name = "tipo_de_convenio_id_seq", sequenceName = "tipo_de_convenio_id_seq", allocationSize = 1)
    @Column(name="ID_TIPO_DE_CONVENIO")
    private int ID_TIPO_DE_CONVENIO;

    @Column(name="NOMBRE")
    private String NOMBRE;

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo_de_convenio", cascade = CascadeType.ALL)
    List<Proyecto> proyecto = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo_de_convenio", cascade = CascadeType.ALL)
    List<Plantilla> plantilla = new ArrayList<>();



}
