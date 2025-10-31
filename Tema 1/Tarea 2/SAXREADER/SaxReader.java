package SAXREADER;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SaxReader {

    public static List<LibroSax> read(File xmlFile) throws Exception {

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser parser = spf.newSAXParser();

        List<LibroSax> libros = new ArrayList<>();

        DefaultHandler handler = new DefaultHandler() {
            LibroSax libroActual;
            StringBuilder sb = new StringBuilder();

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if ("book".equals(qName)) {
                    libroActual = new LibroSax();
                    libroActual.setId(attributes.getValue("id"));
                    libroActual.setIsbn(attributes.getValue("isbn"));
                }
                else if("price".equals(qName)) libroActual.setMoneda(attributes.getValue("currency"));
                sb.setLength(0);
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                sb.append(ch, start, length);
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                String text = sb.toString().trim();
                if (libroActual != null) {
                    switch (qName) {
                        case "title":  libroActual.setTitle(text); break;
                        case "author": libroActual.anadirAutores(text); break;
                        case "category": libroActual.anadirCategoria(text); break;
                        case "year":   if (!text.isEmpty()) libroActual.setAno(Integer.parseInt(text)); break;
                        case "price":  if (!text.isEmpty()) libroActual.setPrecio(Double.parseDouble(text)); break;
                        case "book":   libros.add(libroActual); libroActual = null; break;
                    }
                }
            }
        };

        parser.parse(xmlFile, handler);
        return libros;
    }
}
