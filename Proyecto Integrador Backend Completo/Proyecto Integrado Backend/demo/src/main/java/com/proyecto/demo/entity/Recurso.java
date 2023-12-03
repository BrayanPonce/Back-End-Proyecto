package com.proyecto.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="RECURSO")
public class Recurso {
    
    @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recurso_id_seq")
    @SequenceGenerator(name = "recurso_id_seq", sequenceName = "recurso_id_seq", allocationSize = 1) 
    @Column(name="ID_RECURSO")
    private int ID_RECURSO;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "ID_PROYECTO")
   private Proyecto proyecto;

    @Column(name="URL")
    private String URL;

    @Column(name="NOMBRE")
    private String NOMBRE;
}
