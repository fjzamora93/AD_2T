package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery( name = "Personaje.findAll", query = "FROM Personaje" )
@ToString
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "clase")
    private String clase;

    @Column(name = "raza")
    private String raza;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "id_statset" )
    private StatSet statset;

    @ManyToOne( cascade =  CascadeType.ALL )
    @JoinColumn( name = "id_usuario" )
    private Usuario usuario;

    @ManyToMany( cascade= CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable(
            name = "personaje_habilidades",
            joinColumns = @JoinColumn( name = "id_personaje" ),
            inverseJoinColumns = @JoinColumn( name = "id_habilidad" )
    )
    private List<Habilidad> habilidades;
}

