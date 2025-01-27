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
public class StatSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "constitucion")
    private int constitucion;

    @Column(name = "destreza")
    private int destreza;

    @Column(name = "fuerza")
    private int fuerza;

    @Column(name = "inteligencia")
    private int inteligencia;

    @Column(name = "sabiduria")
    private int sabiduria;

    @Column(name = "carisma")
    private int carisma;


    // Ciertamente, no nos interesa saber qué personaje tiene cierto set de habilidades, esta consulta nunca se va a realizar.
    @OneToOne()
    private Personaje personaje;


    @Override
    public String toString() {
        return "StatSet{" +
                "constitucion=" + constitucion +
                ", destreza=" + destreza +
                ", fuerza=" + fuerza +
                ", inteligencia=" + inteligencia +
                ", sabiduria=" + sabiduria +
                ", carisma=" + carisma +
                '}';
    }
}
