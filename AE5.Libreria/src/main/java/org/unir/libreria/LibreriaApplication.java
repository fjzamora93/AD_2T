package org.unir.libreria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
*

Requerimiento 1

La idea de esta aplicación será la de generar un proyecto Spring boot basado en el proyecto de la librería.

Para ello se pide desarrollar el proyecto integrante springboot con hibernate y JDBC que permita las siguientes acciones

    Agregar autores
    Agregar editoriales
    Agregar libros
    Agregar librerías
    *
    Consultar autores
    Consultar libros por librería
    Contra libros
    Consultar librerías

Los mapeos y métodos de petición tendrán que ser los que mejor se adapten a cada una de las acciones

Como siempre, para la entrega del trabajo, además del código fuente se mostrará un video con el funcionamiento de los endpoints desde una web o desde postman o  thunderclient

*
* */
@SpringBootApplication
public class LibreriaApplication {

    public static void main(String[] args) {

        SpringApplication.run(LibreriaApplication.class, args);
    }

}
