package org.unir.examen.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_curso")
    @JsonIgnore()
    private Curso curso;

    public Alumno(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
}