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
@Table(name="ROL_SISTEMA_ACCESOS")
public class Rol_Sistema_Accesos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_sistema_accesos_id_seq")
    @SequenceGenerator(name = "rol_sistema_accesos_id_seq", sequenceName = "rol_sistema_accesos_id_seq", allocationSize = 1)
    @Column(name="ID_ROL_SISTEMA_ACCESOS")
    private int ID_ROL_SISTEMA_ACCESOS;

    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "ID_ROL_SISTEMA")
   private Rol_Sistema rol_sistema;

    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "ID_ACCESOS")
   private Acceso acceso;

   


}
