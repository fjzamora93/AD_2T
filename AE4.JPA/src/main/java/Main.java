import dao.AutorDAO;
import dao.LibreriaDAO;
import dao.LibroDAO;
import model.Autor;
import model.Libreria;
import model.Libro;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LibroDAO libroDAO = new LibroDAO();
        AutorDAO autorDAO = new AutorDAO();
        LibreriaDAO libreriaDAO = new LibreriaDAO();

        int opcion;

        do {
            System.out.println("1. Mostrar todos los libros con su editorial y autor");
            System.out.println("2. Mostrar todos los autores con sus libros");
            System.out.println("3. Mostrar todas las librerías con sus libros");
            System.out.println("4. Mostrar todos los libros y las librerías en las que están");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    List<Libro> libros = libroDAO.mostrarLibrosConEditorialYAutor();
                    System.out.println("Libros con su editorial y autor:");
                    for (Libro libro : libros) {
                        System.out.println("Título: " + libro.getTitulo() +
                                ", Autor: " + libro.getAutor().getNombre() +
                                ", Editorial: " + libro.getEditorial().getNombre());
                    }
                    break;

                case 2:
                    List<Autor> autores = autorDAO.mostrarAutoresConLibros();
                    System.out.println("Autores con sus libros:");
                    for (Autor autor : autores) {
                        System.out.println("Autor: " + autor.getNombre());
                        System.out.println("Libros:"+ autor.getLibros().toString());
                    }
                    break;

                case 3:
                    List<Libreria> librerias = libreriaDAO.mostrarLibreriasConLibros();
                    System.out.println("Librerías con sus libros:");
                    for (Libreria libreria : librerias) {
                        System.out.println("Librería: " + libreria.getNombre());
                        System.out.println("Libros:" + libreria.getLibros().toString());
                    }
                    break;

                case 4:
                    List<Libro> librosConLibrerias = libroDAO.mostrarLibrosEnLibrerias();
                    System.out.println("Libros y las librerías en las que están:");
                    for (Libro libro : librosConLibrerias) {
                        System.out.println("Título: " + libro.getTitulo());
                        System.out.println("Librerías:");
                        for (Libreria libreria : libro.getLibrerias()) {
                            System.out.println(" - " + libreria.getNombre());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Chao...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}