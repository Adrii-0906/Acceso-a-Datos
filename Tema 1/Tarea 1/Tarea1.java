import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarea1 {

    public static void main(String[] args) {
        //Ejercicio1();
        //Ejercicio2();
        //Ejercicio3();
        //Ejercicio4();
        Ejercicio5();
    }

    public static void Ejercicio1() {
        /*
        Crear fichero con la siguiente estructura para cada fila:
            ID:Nombre:Edad (1:Juan:20)
        Leer toda la línea y mostrar solo el nombre en cada fila.
         */

        try {
            // Creamos el fichero para poder trabajar sobre el

            File file = new File("ejercicio1.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println("Nombre: " + linea.split(":")[1]);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Ejercicio2() {
        /*
            Crear un fichero con un número en cada fila
            Guardar los números en un ArrayList<Integer> y mostrar la suma y la media
         */

        ArrayList<Integer> numerosTxt = new ArrayList<>();

        try {
            File file = new File("ejercicio2.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String numeros;
            Integer suma=0;
            int contador = 0;
            while ((numeros= br.readLine()) != null) {
                suma+=Integer.parseInt(numeros);
                numerosTxt.add(Integer.parseInt(numeros));
            }

            double media = (double) suma /numerosTxt.size();

            System.out.println("La suma total es igual: " + suma);
            System.out.println("La media de los numeros es: " + media);

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Ejercicio3() {
        /*
        Pedir por consola nombres de alumnos hasta que el usuario escriba "fin"
        Guardarlos en salida.txt, un nombre por línea.
         */
        Scanner scanner = new Scanner(System.in);

        File file = new File("salida.txt");

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            System.out.println("Escribe nombres de personas (fin = salir del programa): ");

            while (true) {
                String nombre = scanner.nextLine();

                if (nombre.equalsIgnoreCase("fin")) {
                    break;
                }

                bw.write("Nombre: " + nombre);
                bw.newLine();
            }

            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void Ejercicio4() {
        /*
        Crear fichero empleado.txt con la siguiente estructura:
            Juan;25;Programador
            Ana;30;Diseñadora
        Leer el fichero, crear objetos Empleado y guardarlos en un ArrayList<Empleado>.
        Mostrar luego todos los empleados.
         */

        File file = new File("empleado.txt");


        ArrayList<Empleado> empleados = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] empleado = linea.split(";");
                empleados.add(new Empleado(empleado[0], empleado[1],empleado[2]));
            }

            System.out.println(empleados);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Ejercicio5() {
        /*
        Crear fichero productos.txt
            1;Teclado;25.5
            2;Raton;15.0
            3;Monitor;200.0
        Leer todos los productos en memoria, aumentar todos los precios un 10% y guardarlos en productos_actualizados.txt
         */

        File file = new File("productos.txt");
        File file2 = new File("/home/adrian/Documentos/2DAM/Acceso a Datos/Tema 1/Tarea 1/productos_actualizados.txt");
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));

            String linea;

            while ((linea= br.readLine()) != null) {

                String[] partes = linea.split(";");

                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                double precio = Double.parseDouble(partes[2]);
                productos.add(new Producto(id,nombre,precio));
            }

            System.out.println(" == PRODUCOTS SIN AUMENTO DE IVA ==");

            System.out.println(productos);
            for (Producto p : productos) {
                p.setPrecio(p.getPrecio() * 1.10);
            }

            for (Producto p : productos) {
                bw.write(p.toString());
                bw.newLine();
            }

            System.out.println("Correctamente actualizado");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
