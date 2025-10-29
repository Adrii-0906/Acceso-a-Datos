import java.io.*;
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

            System.out.print("Dime que accion quieres realizar(0 = fin del programa): ");
            option = entrada.nextInt();

           if (option == 1) {
               anadirAlumnos();
           } else if (option == 2) {
               delvolverId();
           } else if (option == 3) {
               insertarNotas();
           } else if (option == 4) {
               calcularMedia();
           }
        } while (option != 0);
    }


    public static void anadirAlumnos() {
        int opcion = 0;
        do {
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
                BufferedReader br = new BufferedReader(new FileReader(file));
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

                int id = 0;

                String linea;
                while ((linea = br.readLine()) != null) {
                    id++;
                }

                String cadena = id + "|" + nombre + "|" + apellido + "|" + fechaNac + "|" + clase;

                bw.write(cadena);
                bw.newLine();

                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Si quieres anadir otro alumno pulsa '1' si no pulsa '0'");
            opcion = Integer.parseInt(sc.nextLine());
        } while (opcion!= 0);
    }

    public static void delvolverId() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Dime el nombre del alumno: ");
        String nombre = entrada.nextLine();

        System.out.println("Dime el apellido del alumno: ");
        String apellido = entrada.nextLine();

        sacarId(nombre, apellido);

        System.out.println("El id de " + nombre + " " + apellido + " = " + sacarId(nombre, apellido));

    }


    public static int sacarId(String nombre, String apellidos){
        try {
            File file = new File("Alumnos.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split("\\|");

                if (nombre.equals(partes[1]) & apellidos.equals(partes[2])) {
                    return Integer.parseInt(partes[0]);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.printf("El alumno con nombre" + nombre + "apellido" + apellidos + " no se encuentra en el archivo");
        }
        return 0;
    }

    public static void insertarNotas() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Dime el nombre del alumno: ");
        String nombre = entrada.nextLine();

        System.out.println("Dime el apellido del alumno: ");
        String apellido = entrada.nextLine();


        try {
            File file = new File("Notas.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

            System.out.print("Dime las notas de " + nombre + " separadas por ';' ");
            String nota = entrada.nextLine();


            String cadena = sacarId(nombre, apellido) + "|" + nota;

            bw.write(cadena);
            bw.newLine();

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void calcularMedia() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Dime el nombre del alumno: ");
        String nombre = entrada.nextLine();

        System.out.println("Dime el apellido del alumno: ");
        String apellido = entrada.nextLine();

        try {
            File file = new File("Notas.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;
            double suma = 0;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");

                int idtenido = Integer.parseInt(partes[0]);

               if (idtenido == sacarId(nombre, apellido)) {
                   String[] partes1 = partes[1].split(";");
                   System.out.println("La media del alumno es: ");

                   for (int i = 0; i < partes1.length; i++) {
                       suma += Double.parseDouble(partes1[i]);
                   }
                   double media = suma / partes1.length;

                   System.out.println("Media = " + media);

                   break;
               }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
