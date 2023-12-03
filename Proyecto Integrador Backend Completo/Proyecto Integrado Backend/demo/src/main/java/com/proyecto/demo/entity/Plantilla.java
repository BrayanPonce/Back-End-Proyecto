package com.proyecto.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;


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
@Table(name="PLANTILLA")
public class Plantilla {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plantilla_id_seq")
    @SequenceGenerator(name = "plantilla_id_seq", sequenceName = "plantilla_id_seq", allocationSize = 1)
    @Column(name="ID_PLANTILLA")
    private int ID_PLANTILLA;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "ID_TIPO_CONVENIO")
    @JsonIgnore
   private Tipo_De_Convenio tipo_de_convenio;

    @Column(name="URL")
    private String URL;

    @Column(name="NOMBRE")
    private String NOMBRE;
}
