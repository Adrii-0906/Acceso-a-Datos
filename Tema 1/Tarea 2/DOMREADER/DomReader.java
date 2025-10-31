package DOMREADER;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DomReader {

    public static List<LibroDOM> read(File xml) throws Exception{

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(xml);

        NodeList nodosLibros = doc.getElementsByTagName("book");
        List<LibroDOM> libros = new ArrayList<>();

        for (int i = 0; i < nodosLibros.getLength(); i++) {
            Element e = (Element) nodosLibros.item(i);

            LibroDOM libro = new LibroDOM();

            libro.setId(e.getAttribute("id"));
            libro.setIsbn(e.getAttribute("isbn"));
            libro.setTitle(e.getAttribute("title"));

            NodeList autores = e.getElementsByTagName("author");

            for (int j = 0; j <autores.getLength(); j++) {
                String role = ((Element) autores.item(j)).getAttribute("role");
                if (role.isEmpty()) {
                    libro.anadirAutores(autores.item(j).getTextContent());
                } else {
                    libro.anadirAutores(autores.item(j).getTextContent() + " (" + role + ")");
                }
            }

            NodeList categorias = e.getElementsByTagName("category");
            for (int j = 0;j < categorias.getLength(); j++) {
                libro.anadirCategoria(categorias.item(j).getTextContent());
            }

            NodeList precio = e.getElementsByTagName("price");
            libro.setMoneda(((Element) precio.item(0)).getAttribute("currency"));

            libro.setAno(parsearInt(obtenerTexto(e, "year")));
            libro.setPrecio(parsearDouble(obtenerTexto(e, "price")));

            libros.add(libro);

        }

        return libros;
    }


    private static String obtenerTexto(Element parent, String tag) {
        NodeList nl = parent.getElementsByTagName(tag);
        return (nl.getLength() > 0) ? nl.item(0).getTextContent().trim() : "";
    }

    private static int parsearInt(String cadena) {
        return cadena.isEmpty() ? 0 : Integer.parseInt(cadena);
    }

    private static double parsearDouble(String cadena) {
        return cadena.isEmpty() ? 0 : Double.parseDouble(cadena);
    }
}
