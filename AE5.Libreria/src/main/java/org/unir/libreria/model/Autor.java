package org.unir.libreria.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "autor")
@NamedQuery(name = "Autor.findAll", query = "FROM Autor")
public class Autor implements Serializable {
    public Autor(String nombre, String fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private String nombre;


    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @OneToMany( mappedBy = "autor", fetch = FetchType.EAGER)
    @JsonManagedReference("autor-libros")
    private List<Libro> libros;


}