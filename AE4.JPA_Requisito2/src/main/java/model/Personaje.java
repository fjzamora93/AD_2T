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

    @OneToOne()
    private StatSet statset;

    @ManyToOne()
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Habilidad> habilidades;
}

