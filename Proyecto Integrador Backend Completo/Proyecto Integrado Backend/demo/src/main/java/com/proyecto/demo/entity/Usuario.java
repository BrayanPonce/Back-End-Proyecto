package com.proyecto.demo.entity;





import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
    @SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq", allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private int ID_USUARIO;

    
    @Column(name = "USERNAME")
    @NotBlank
    private String USERNAME;

    @Column(name = "PASSWORD")
    @NotBlank
    private String PASSWORD;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Persona personaR;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity =  Rol_Sistema.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "USUARIO_ROL_SISTEMA", joinColumns = @JoinColumn(name = "ID_USUARIO"), inverseJoinColumns = @JoinColumn(name = "ID_ROL_SISTEMA"))
    private Set<Rol_Sistema> roles;
    

}
