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
@Table(name="ACTIVIDAD_PARTICIPANTE")
public class Actividad_Participante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actividad_participante_id_seq")
    @SequenceGenerator(name = "actividad_participante_id_seq", sequenceName = "actividad_participante_id_seq", allocationSize = 1)
    @Column(name="ID_ACTIVIDAD_PARTICIPANTE")
    private int ID_ACTIVIDAD_PARTICIPANTE;

    @Column(name="asistencia")
    private boolean ASISTENCIA;

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PARTICIPANTE")
    private Participante participante;

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ACTIVIDAD")
    private Actividad actividad;

}