package com.proyecto.demo.entity;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="ROL_NEGOCIO")
public class Rol_Negocio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_negocio_id_seq")
    @SequenceGenerator(name = "rol_negocio_id_seq", sequenceName = "rol_negocio_id_seq", allocationSize = 1)
    @Column(name="ID_ROL_NEGOCIO")
    private int ID_ROL_NEGOCIO;

    @Column(name="NOMBRE")
    private String NOMBRE;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol_negocio", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Rol_Proyecto> rol_proyecto = new ArrayList<>();

}
