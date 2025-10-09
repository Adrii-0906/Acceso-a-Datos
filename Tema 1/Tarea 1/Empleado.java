public class Empleado {

    private String nombre;
    private String edad;
    private String profesion;


    public Empleado(String nombre, String edad, String profesion) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Empleado{" + '\n' +
                "nombre='" + nombre + '\n' +
                ", edad=" + edad + '\n' +
                ", profesion='" + profesion + '\n' +
                '}' + '\n';
    }
}
