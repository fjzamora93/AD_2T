package org.unir.examen.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private int id;

    @Column()
    private String nombre;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_aula")
    private Aula aula;


    @OneToMany( mappedBy = "curso", fetch = FetchType.EAGER)
    @JsonBackReference("alumno-curso")
    private List<Alumno> alumnos;


    @ManyToMany(
            mappedBy = "cursos",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JsonIgnore
    private List<Profesor> profesores;




}
