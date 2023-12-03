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
@Table(name="USUARIO_ACCESOS")
public class Usuario_Accesos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_accesos_id_seq")
    @SequenceGenerator(name = "usuario_accesos_id_seq", sequenceName = "usuario_accesos_id_seq", allocationSize = 1)
    @Column(name="ID_USUARIO_ACCESOS")
    private int ID_USUARIO_ACCESO;

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ACCESOS")
    private Acceso acceso;

}