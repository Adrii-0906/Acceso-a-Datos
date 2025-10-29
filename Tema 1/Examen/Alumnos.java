import java.util.Date;
import java.util.Objects;

public class Alumnos {

    // Atributos
    private int id;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String clase;

    public Alumnos(int id, String nombre, String apellidos, String fechaNacimiento, String clase) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
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

    public void setApellido(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int buscarAlumno(String nombre, String apellido) {
        if (Objects.equals(nombre, this.nombre) & Objects.equals(apellido, this.apellidos)) {
            System.out.println("Alumno encontrado. Su id es: ");
            return id;
        } else {
            System.out.println("No ha sido econtrado");
        }
        return 0;
    }


    @Override
    public String toString() {
        return id + "|" + nombre + "|" + apellidos + "|" + fechaNacimiento +"|" + clase + "\n";
    }
}
