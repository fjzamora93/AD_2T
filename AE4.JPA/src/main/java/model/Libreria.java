package model;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "libreria")
public class Libreria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String direccion;

    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable(
            name = "libro_en_libreria",
            joinColumns = @JoinColumn( name = "id_libreria" ),
            inverseJoinColumns = @JoinColumn(name = "id_libro")
    )
    private List<Libro> libros;
}