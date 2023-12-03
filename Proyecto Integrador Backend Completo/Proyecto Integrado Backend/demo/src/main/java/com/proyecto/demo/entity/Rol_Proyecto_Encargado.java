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
@Table(name="ROL_PROYECTO_ENCARGADO")
public class Rol_Proyecto_Encargado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_proyecto_encargado_id_seq")
    @SequenceGenerator(name = "rol_proyecto_encargado_id_seq", sequenceName = "rol_proyecto_encargado_id_seq", allocationSize = 1)
    @Column(name="ID_ROL_PROYECTO_ENCARGADO")
    private int ID_ROL_PROYECTO_ENCARGADO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROL_PROYECTO")
    private Rol_Proyecto rol_proyecto;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ENCARGADO")
    private Encargado encargado;

    

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol_proyecto_encargado", cascade = CascadeType.ALL)
    List<Participante> participante = new ArrayList<>();



}
