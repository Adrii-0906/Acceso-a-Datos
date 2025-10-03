import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            File rutaXML = new File("/Tarea 2/catalogo.xml");
            List<Libro> libros = DomReader.read(rutaXML);

        } catch (Exception e) {
            System.out.println("Error: ");
        }
    }
}
