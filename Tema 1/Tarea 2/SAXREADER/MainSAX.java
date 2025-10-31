package SAXREADER;

import DOMREADER.LibroDOM;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainSAX {

    public static void main(String[] args) {
        File xml = new File("catalogo.xml");
        List<LibroSax> libros = new ArrayList<>();

        try {
            libros = SaxReader.read(xml);
            libros.forEach(System.out::println);
            consultasLibros(libros);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void consultasLibros(List<LibroSax> libros) {
        System.out.println("Solo libros publicados despues de 2010 \n");

        for (LibroSax libro : libros) {
            if (libro.getAno() > 2010) {
                System.out.println(libro);
            }
        }

        System.out.println("Libros con mas de un autor \n");

        for (LibroSax libro : libros) {
            if (libro.getAutores().size() > 1) {
                System.out.println(libro);
            }
        }

        System.out.println();

        double sumaEUR = 0;
        int contador = 0;
        for (LibroSax libro : libros) {
            if (libro.getMoneda().equals("EUR")) {
                sumaEUR+= libro.getPrecio();
                contador++;
            }
        }

        System.out.println("El precio medio de los libros con moneda 'EUR': " + sumaEUR / contador);
    }
}
