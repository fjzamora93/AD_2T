package model;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
@Entity
@NamedQuery(name = "Libro.findAll", query = "FROM Libro")
@Table(name = "libro")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column()
    private String titulo;

    @Column
    private Double precio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_autor")
    private Autor autor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    @ManyToMany(
            mappedBy = "libros",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Libreria> librerias;

    public Libro(String titulo, Double precio, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.precio = precio;
        this.autor = autor;
        this.editorial = editorial;
        this.librerias = new ArrayList<>();
    }
}
