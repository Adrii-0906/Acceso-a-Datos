import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Repaso {

    public static void main(String[] args) {
        //Ejercicio1();
        //Ejercicio2();
        //Ejercicio3();
        //Ejercicio4();
        //Ejercicio5();
    }

    public static void Ejercicio1() {
        /*
        - Crear fichero con la siguiente estructura para cada fila:
            ID:Nombre:Edad (1:Juan:20)
        - Leer toda la línea y mostrar solo el nombre en cada fila.
         */

        // Creamos la excepcion
        try {
            // Creamos elarchivo file para poder saber donde esta el fichero
            File file = new File("fichero.txt");

            // Con el BufferedReader leemos el fichero
            BufferedReader br = new BufferedReader(new FileReader(file));

            // Creamos la cadena de texto que vamos a leer
            String linea;

            // Con el bucle while lo que hacemos es leer cada linea hasta que haya una linea que no tenga texto
            while((linea = br.readLine()) != null) {

                String[] nombre = linea.split(":");
                // Ahora para saber como mostrar solo el texto usamos spit que lo que hace es separar y lo imprimimos
                // Como el nombre esta detras de los ':' le decimos que lea despues de los ':' pero solo de los primer ':'
                System.out.println(nombre[1]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Ejercicio2() {

        /*
        - Crear un fichero con un número en cada fila
        - Guardar los números en un ArrayList<Integer> y mostrar la suma y la media.
        */

        ArrayList<Integer> numeros = new ArrayList<>();

        try {

            File file = new File("ficheroNum.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            int suma = 0;
            String num;
            while ((num = br.readLine()) != null) {
                int numInt = Integer.parseInt(num);
                numeros.add(numInt);
                suma += (numInt);
            }

            System.out.println(numeros);
            System.out.println("La suma total de los numeros es: " + suma);
            System.out.println("La media de los numeros es: " + suma / numeros.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Ejercicio3() {
        /*
        - Pedir por consola nombres de alumnos hasta que el usuario escriba "fin"
        - Guardarlos en salida.txt, un nombre por línea.
         */

        Scanner sc = new Scanner(System.in);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("ficheroAlumnos.txt"))) {

            String alumno;

            while (true) {
                System.out.println("Dime alumnos para apuntar en el fichero (Palabra fin = Salir del programa): ");
                alumno = sc.nextLine();

                if (alumno.equalsIgnoreCase("fin")) {
                    break;
                }

                bw.write(alumno);
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Ejercicio4() {
        /*
        - Crear fichero empleado.txt con la siguiente estructura:
            Juan;25;Programador
            Ana;30;Diseñadora
        - Leer el fichero, crear objetos Empleado y guardarlos en un ArrayList<Empleado>.
          Mostrar luego todos los empleados.
         */

        ArrayList<Empleado> empleados = new ArrayList<>();

        try {
            File file = new File("empleado.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] empleado = linea.split(";");

                empleados.add(new Empleado(empleado[0], empleado[1], empleado[2]));
            }
            System.out.println(empleados);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void  Ejercicio5() {
        /*
        - Crear fichero productos.txt
            1;Teclado;25.5
            2;Raton;15.0
            3;Monitor;200.0
        - Leer todos los productos en memoria, aumentar todos los precios un 10% y
          guardarlos en productos_actualizados.txt
          */

        ArrayList<Productos> productos = new ArrayList<>();

        File fileProductos = new File("productos.txt");
        File fileProductosActualizados = new File("productos_Actualizados.txt");
        try {


            BufferedReader br = new BufferedReader(new FileReader(fileProductos));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileProductosActualizados));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] producto = linea.split(";");

                int id = Integer.parseInt(producto[0]);
                String nombre = producto[1];
                double precio = Double.parseDouble(producto[2]);

                productos.add(new Productos(id, nombre, precio));
            }

            System.out.println("Fichero Productos leido: ");
            System.out.println(productos);

            for (Productos p : productos) {
                p.aumentarPrecio(10);
            }

            for (Productos p : productos) {
                bw.write(p.toString());
                bw.newLine();
            }

            System.out.println("Escribimos en el fichero de Productos_Actualizados");

            bw.close();
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
