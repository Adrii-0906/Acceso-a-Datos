import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Examen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("1 - Añadir alumnos");
        System.out.println("2 - Devolver el ID de un alumno (por nombre y apellido)");
        System.out.println("3 - Insertar notas");
        System.out.println("4 - Calcular la media de notas de un alumno");
        System.out.println("0 - Salir del programa");

        while(true) {
            System.out.println("Dime una de las opciones: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                anadirAlumnos();
            } else if (opcion == 2) {
                devolverID();
            } else if (opcion == 3) {
                anadirNotas();
            } else if (opcion == 4) {
                calcularMedia();
            } else if (opcion == 0) {
                System.out.println("Saliendo del programa: ");
                break;
            }
        }

    }

    static ArrayList<Alumnos> alumnosList = new ArrayList<>();
    public static void anadirAlumnos() {

        Scanner sc = new Scanner(System.in);
        File file = new File("ficheroAlumnos.txt");



        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

            System.out.println("Dime la id del alumno: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Introduzca el nombre: ");
            String nombre = sc.nextLine();

            System.out.println("Introduzca los apellidos: ");
            String apellidos = sc.nextLine();

            System.out.println("Introduzca la fecha de nacimiento: ");
            String fechaNac = sc.nextLine();

            System.out.println("Introduzca la clase del alumno: ");
            String clase = sc.nextLine();

            alumnosList.add(new Alumnos(id, nombre, apellidos,fechaNac, clase));

            bw.write(String.valueOf(alumnosList));
            bw.newLine();

            bw.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void devolverID() {
        File file = new File("ficheroAlumnos.txt");
        Scanner sc = new Scanner(System.in);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            System.out.println("Introduzca nombre del alumno: ");
            String nombre = sc.nextLine();

            System.out.println("Introduzca los apellidos del alumno: ");
            String apellidos = sc.nextLine();

            for (Alumnos a : alumnosList) {
                a.buscarAlumno(nombre,apellidos);
                System.out.println(a.getId());
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void anadirNotas() {
        File fileNotas = new File("notas.txt");
        Scanner sc = new Scanner(System.in);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileNotas, true));

            System.out.println("Introduce el nombre del alumno: ");
            String nombre = sc.nextLine();

            System.out.println("Introduce los apellidos del Alumno: ");
            String apellidos = sc.nextLine();

            for (Alumnos a : alumnosList) {
                a.buscarAlumno(nombre, apellidos);
                System.out.println("Introduzca las notas para el alumno " + a.getId());
                System.out.println("Notas: ");
                double notas1 = sc.nextDouble();
                double notas2 = sc.nextDouble();
                double notas3 = sc.nextDouble();
                double notas4 = sc.nextDouble();
                double notas5 = sc.nextDouble();

                bw.write(a.getId() + "|" + notas1 + ";" + notas2 + ";" + notas3 + ";" + notas4 + ";" + notas5);
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void calcularMedia() {
        File fileNotas2 = new File("notas.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileNotas2));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parteID = linea.split("|");
                String[] partesNotas = linea.split(";");

                System.out.println(partesNotas);
                double calcularMedia = Double.parseDouble(partesNotas[0] + partesNotas[1] + partesNotas[2] + partesNotas[3] + partesNotas[4]);

                System.out.println("El alumno con la ID '" + parteID[0] + "' su media es: " + calcularMedia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
