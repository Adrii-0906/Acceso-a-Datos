import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = 0;

        do {
            System.out.println("1.- Anadir Alumnos");
            System.out.println("2.- Devolver id");
            System.out.println("3.- Anadir Notas");
            System.out.println("4.- Calcular Media");

            System.out.println("Dime que funcion quieres ejecutar: ");
            option = Integer.parseInt(sc.nextLine());

            if (option == 1) {
                anadirAlumnos(sc);
            } else if (option == 2) {
                devolverId(sc);
            } else if (option == 3) {
                insertarNotas(sc);
            } else if (option == 4) {
                calcularMedia(sc);
            }


        } while (option != 0);
    }


    public static void anadirAlumnos(Scanner sc) {
        int anadirMas = 0;
        do {
            int id = 0;

            System.out.println("Dime el nombre del alumno: ");
            String nombre = sc.nextLine();

            System.out.println("Dime el apellido del alumno: ");
            String apellido = sc.nextLine();

            System.out.println("Dime la fecha de nacimiento del alumno: ");
            String fechaNac =  sc.nextLine();

            System.out.println("Dime la clase del alumno: ");
            String clase = sc.nextLine();

            try {
                File file = new File("Alumnos.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

                String linea;

                while ((linea = br.readLine()) != null) {
                    id++;
                }

                String cadena = id + "|" + nombre + "|" + apellido + "|" + fechaNac + "|" + clase;

                bw.write(cadena);
                bw.newLine();

                br.close();
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Quieres anadir otro alumno '1' o quieres continuar '0': ");
            anadirMas = Integer.parseInt(sc.nextLine());

        } while (anadirMas!=0);
    }

    public static int sacarId(String nombre, String apellido) {
        try {
            File file = new File("Alumnos.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (nombre.equals(partes[1]) & apellido.equals(partes[2])) {
                    return Integer.parseInt(partes[0]);
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void devolverId(Scanner sc) {

        System.out.println("Dime el nombre del alumno: ");
        String nombre = sc.nextLine();

        System.out.println("Dime el apellido del alumno: ");
        String apellido = sc.nextLine();

        System.out.println("El id de" + nombre + " " + apellido + " es: " + sacarId(nombre, apellido));
    }

    public static void insertarNotas(Scanner sc) {

        System.out.println("Dime el nombre del alumno: ");
        String nombre = sc.nextLine();

        System.out.println("Dime el apellido del alumno: ");
        String apellido = sc.nextLine();

        System.out.println("El id de" + nombre + " " + apellido + " es: " + sacarId(nombre, apellido));


        try {
            File file = new File("Notas.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

            System.out.println("Dime las notas de " + nombre + " separandolas con ';': ");
            String notas = sc.nextLine();

            String cadenaNotas = sacarId(nombre, apellido) + "|" + notas;

            bw.write(cadenaNotas);
            bw.newLine();

            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void calcularMedia(Scanner sc) {

        System.out.println("Dime el nombre del alumno: ");
        String nombre = sc.nextLine();

        System.out.println("Dime el apellido del alumno: ");
        String apellido = sc.nextLine();
        try {
            File file = new File("Notas.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;
            double suma = 0;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");

                int idObtenido = Integer.parseInt(partes[0]);

                if (idObtenido == sacarId(nombre, apellido)) {
                    String[] notas = partes[1].split(";");

                    for (int i = 0; i < notas.length; i++) {
                        suma += Double.parseDouble(notas[i]);
                    }

                    double media = suma / notas.length;

                    System.out.println("La media total es: " + media);

                    break;
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}