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
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "efecto")
    private String efecto;

    // Esta consulta tampoco nos va a interesar hacerla nunca, aunque lo dejamos abierto
    @ManyToMany(
            mappedBy = "habilidades",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Personaje> personajes;

    @Override
    public String toString() {
        return "Habilidad{" +
                "nombre='" + nombre + '\'' +
                ", efecto='" + efecto + '\'' +
                '}';
    }
}
