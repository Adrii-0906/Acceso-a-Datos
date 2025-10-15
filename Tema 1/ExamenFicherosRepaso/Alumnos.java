public class Alumnos {

    private static int id = 0;
    private String nombre;
    private String apellidos;
    private String fechaNac;
    private String clase;

    public Alumnos(String nombre, String apellidos, String fechaNac, String clase) {
        id++;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.clase = clase;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int obtenerId(String nombre, String apellido) {
        if (this.nombre == nombre & this.apellidos == apellido) {
            System.out.println("La id de " + nombre + apellidos + " es: " + id);
            return id;
        }
        return 0;
    }


    @Override
    public String toString() {
        return this.id + "|" + this.nombre + "|" + apellidos + "|" + fechaNac + "|" + clase;
    }
}
