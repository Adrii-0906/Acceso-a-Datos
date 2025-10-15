import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainAlumnos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int option;

        do {
            System.out.println("1 - Anadir Alumnos");
            System.out.println("2 - Devolver el ID de un alumno (por nombre y apellido)");
            System.out.println("3 - Insertar notas");
            System.out.println("4 - Calcular la media de notas");
            System.out.println("0 - Salir del programa \n");

            System.out.println("Dime que accion quieres realizar(0 = fin del programa): ");
            option = entrada.nextInt();

            switch (option) {
                case 1:
                    anadirAlumnos();
                case 2:
                    delvolverId();
                case 3:
                    insertarNotas();
                case 4:
                    calcularMedia();
                case 0:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opcion invalida, intentalo de nuevo");
            }
        } while (option != 0);
    }


    static ArrayList<Alumnos> alumnosList = new ArrayList<>();
    public static void anadirAlumnos() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dime el nombre del alumno: ");
        String nombre = sc.nextLine();

        System.out.println("Dime los apellidos del alumno: ");
        String apellido = sc.nextLine();

        System.out.println("Dime la fecha de nacimiento del alumno: ");
        String fechaNac = sc.nextLine();

        System.out.println("Dime la clase del alumno: ");
        String clase = sc.nextLine();

        try {
            File file = new File("Alumnos.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

            Alumnos cadena = new Alumnos(nombre,apellido,fechaNac,clase);

            alumnosList.add(cadena);

            bw.write(cadena.toString());
            bw.newLine();

            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delvolverId() {
//        Scanner entrada = new Scanner(System.in);
//
//        System.out.println("Dime el nombre del alumno: ");
//        String nombre = entrada.nextLine();
//
//        System.out.println("Dime el apellido del alumno: ");
//        String apellido = entrada.nextLine();
//
//        for (Alumnos a : alumnosList) {
//            a.obtenerId(nombre, apellido);
//        }
//
      }

    public static void insertarNotas() {

    }

    public static void calcularMedia() {

    }
}
