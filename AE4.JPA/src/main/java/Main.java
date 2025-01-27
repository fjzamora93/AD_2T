import dao.AutorDAO;
import dao.EditorialDAO;
import dao.LibreriaDAO;
import dao.LibroDAO;
import model.Autor;
import model.Editorial;
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
            System.out.println("5. Hacer la carga de todos los datos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    List<Libro> libros = libroDAO.mostrarTodos();
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
                    List<Libro> librosConLibrerias = libroDAO.mostrarTodos();
                    System.out.println("Libros y las librerías en las que están:");
                    for (Libro libro : librosConLibrerias) {
                        System.out.println("Título: " + libro.getTitulo());
                        System.out.println("Librerías:");
                        for (Libreria libreria : libro.getLibrerias()) {
                            System.out.println(" - " + libreria.getNombre());
                        }
                    }
                    break;
                case 5:
                    cargarDatos();
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



    public static void cargarDatos(){
        LibroDAO libroDAO = new LibroDAO();
        AutorDAO autorDAO = new AutorDAO();
        LibreriaDAO libreriaDAO = new LibreriaDAO();
        EditorialDAO editorialDao = new EditorialDAO();

        System.out.println("Vamos que nos vamos, cargando editorial, libros, autores y la biblioteca entera:");

        Autor jkRowling = new Autor("J.K. Rowling", "31-07-1965");
        Autor tolkien = new Autor("J.R.R. Tolkien", "03-01-1892");
        Autor georgeMartin = new Autor("George R.R. Martin", "20-09-1948");
        autorDAO.addAutor(jkRowling);
        autorDAO.addAutor(tolkien);
        autorDAO.addAutor(georgeMartin);

        Editorial bloomsbury = new Editorial("Bloomsbury", "50 Bedford Square, London");
        Editorial harperCollins = new Editorial("HarperCollins", "195 Broadway, New York");
        Editorial bantamBooks = new Editorial("Bantam Books", "1745 Broadway, New York");
        editorialDao.addEditorial(bloomsbury);
        editorialDao.addEditorial(harperCollins);
        editorialDao.addEditorial(bantamBooks);

        Libro libro1 = new Libro("Harry Potter and the Philosopher's Stone", 20.99, jkRowling, bloomsbury);
        Libro libro2 = new Libro("Harry Potter and the Chamber of Secrets", 22.99, jkRowling, bloomsbury);
        Libro libro3 = new Libro("The Hobbit", 15.99, tolkien, harperCollins);
        Libro libro4 = new Libro("The Lord of the Rings: The Fellowship of the Ring", 25.99, tolkien, harperCollins);
        Libro libro5 = new Libro("The Lord of the Rings: The Two Towers", 25.99, tolkien, harperCollins);
        Libro libro6 = new Libro("The Lord of the Rings: The Return of the King", 25.99, tolkien, harperCollins);
        Libro libro7 = new Libro("A Game of Thrones", 29.99, georgeMartin, bantamBooks);
        Libro libro8 = new Libro("A Clash of Kings", 29.99, georgeMartin, bantamBooks);
        libroDAO.addLIbro(libro1);
        libroDAO.addLIbro(libro2);
        libroDAO.addLIbro(libro3);
        libroDAO.addLIbro(libro4);
        libroDAO.addLIbro(libro5);
        libroDAO.addLIbro(libro6);
        libroDAO.addLIbro(libro7);
        libroDAO.addLIbro(libro8);

        Libreria libreria1 = new Libreria("Librería Cervantes", "Calle de Cervantes, 10, Madrid");
        Libreria libreria2 = new Libreria("Librería La Central", "Calle de Mallorca, 237, Barcelona");
        libreriaDAO.addLibreria(libreria1);
        libreriaDAO.addLibreria(libreria2);

        libreriaDAO.addLibroToLibreria(libro1, libreria2);
        libreriaDAO.addLibroToLibreria(libro2, libreria2);
        libreriaDAO.addLibroToLibreria(libro3, libreria2);
        libreriaDAO.addLibroToLibreria(libro4, libreria2);
        libreriaDAO.addLibroToLibreria(libro5, libreria1);
        libreriaDAO.addLibroToLibreria(libro6, libreria1);
        libreriaDAO.addLibroToLibreria(libro7, libreria1);
        libreriaDAO.addLibroToLibreria(libro8, libreria1);

    }
}