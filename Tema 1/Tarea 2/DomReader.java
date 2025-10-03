import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DomReader {

    public static List<Libro> read(File xml) throws Exception{

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(xml);

        NodeList nodosLibros = doc.getElementsByTagName("book");
        List<Libro> libros = new ArrayList<>();

        for (int i = 0; i < nodosLibros.getLength(); i++) {
            Element e = (Element) nodosLibros.item(i);

            Libro libro = new Libro();

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


        }

        return libros;
    }
}
