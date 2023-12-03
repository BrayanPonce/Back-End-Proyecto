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
@Table(name="ACCESOS")
public class Acceso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accesos_id_seq")
    @SequenceGenerator(name = "accesos_id_seq", sequenceName = "accesos_id_seq", allocationSize = 1)
    @Column(name="ID_ACCESOS")
    private int ID_ACCESOS;

     @Column(name="NOMBRE")
    private String NOMBRE;

     @Column(name="URL")
    private String URL;

    @Column(name="ID_ACCESOS_PADRE")
    private Integer ID_ACCESOS_PADRE;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "acceso", cascade = CascadeType.ALL)
    List<Usuario_Accesos> persona_accesos = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "acceso", cascade = CascadeType.ALL)
    List<Rol_Sistema_Accesos> rol_sistema_accesos = new ArrayList<>();


}
