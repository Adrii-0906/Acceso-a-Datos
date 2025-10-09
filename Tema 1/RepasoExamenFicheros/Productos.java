public class Productos {

    // Atributos
    private int id;
    private String nombre;
    private double precio;

    // Constructor

    public Productos(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void aumentarPrecio(double aumento) {
        this.precio = this.precio + (this.precio * (aumento / 100));
    }

    @Override
    public String toString() {
        return id + ";" + nombre + ";" + precio + "\n";
    }
}
