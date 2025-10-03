import java.util.ArrayList;
import java.util.List;

public class Libro {

    // Atributos
    private String id;
    private String isbn;
    private String title;
    private List<String> autores;
    private List<String> categorias;
    private int ano;
    private double precio;
    private String moneda;

    // Hacemos el constructor de solo las listas


    public Libro() {
        this.autores = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void anadirAutores(String autores) {
        this.autores.add(autores);
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void anadirCategoria(String categoria) {
        this.categorias.add(categoria);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Override
    public String toString() {
        return "[ " + this.id + " ]" + this.title + "(" + this.ano + ")\n" +
                "ISBN: " + this.isbn + "\n" +
                "Autores: " + this.autores + "\n" +
                "Categorias: " + this.categorias + "\n" +
                "Precio" + this.precio + this.moneda;
    }
}
