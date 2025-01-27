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
@Table(name = "autor")
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


    @Column
    private String fechaNacimiento;

    @OneToMany( mappedBy = "autor", fetch = FetchType.EAGER)
    private List<Libro> libros;


}