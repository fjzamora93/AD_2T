package org.unir.examen.model;

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
@Table(name = "profesor")
public class Profesor implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;

    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable(
            name = "profesor_curso",
            joinColumns = @JoinColumn( name = "id_profesor" ),
            inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    private List<Curso> cursos;

    public Profesor(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
}