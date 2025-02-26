package org.unir.libreria.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonBackReference("autor-libros")
    private Autor autor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_editorial")
    @JsonBackReference("editorial-libros")
    private Editorial editorial;

    @ManyToMany(
            mappedBy = "libros",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JsonIgnore
    private List<LibreriaEntity> librerias;



    public Libro(String titulo, Double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }
}
