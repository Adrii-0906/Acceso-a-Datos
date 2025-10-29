import java.io.*;
import java.util.Scanner;

public class MainProductos {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("1.- Añadir Productos");
            System.out.println("2.- Devolver el Precio de un Producto (por nombre y referencia)");
            System.out.println("3.- Registrar Venta (acumulativa)");
            System.out.println("4.- Calcular Ingreso Total por Producto");
            System.out.println("0.- Finalizar programa");

            System.out.println("Dime que opcion quieres realizar: ");
            opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) {
                anadirProductos(sc);
            } else if (opcion == 2) {
                devolverId(sc);
            } else if (opcion == 3) {
                registrarVenta(sc);
            } else if (opcion == 4) {
                calcularIngresos(sc);
            }

        } while (opcion != 0);
    }


    public static void anadirProductos(Scanner sc) {

        int option;
        do {
            option = 0;
            int id = 1;

            System.out.println("Dime el nombre del producto: ");
            String nombre = sc.nextLine();

            System.out.println("Dime la referencia del producto: ");
            String referencia = sc.nextLine();

            System.out.println("Dime el precio del producto: ");
            double precio = Double.parseDouble(sc.nextLine());

            System.out.println("Dime el Stock inicial del producto: ");
            int stock = Integer.parseInt(sc.nextLine());

            try {
                File file = new File("Productos.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

                String linea;
                while ((linea = br.readLine()) != null) {
                    id++;
                }

                String cadena = id + "|" + nombre + "|" + referencia + "|" + precio + "|" + stock;

                bw.write(cadena);
                bw.newLine();

                br.close();
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Pulsa 1 para insertar otro producto, o 0 para salir: ");
            option = Integer.parseInt(sc.nextLine());
        } while (option != 0);
    }

    public static void devolverId(Scanner sc) {
        System.out.println("Dime el nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.println("Dime la referencia del producto: ");
        String referencia = sc.nextLine();

        System.out.println("La id de " + nombre + " es: " + sacarId(nombre, referencia));
    }

    public static int sacarId(String nombre, String referencia) {
        try {
            File file = new File("Productos.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");

                if (nombre.equals(partes[1]) & referencia.equals(partes[2])) {
                    return Integer.parseInt(partes[0]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void registrarVenta(Scanner sc) {
        System.out.println("Dime el nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.println("Dime la referencia del producto: ");
        String referencia = sc.nextLine();

        System.out.println("La id de " + nombre + " es: " + sacarId(nombre, referencia));

        System.out.println("-----------------------------------------------------------------------");

        int idVentas = sacarId(nombre, referencia);

        System.out.println("Dime los datos de venta del producto: ");
        System.out.println("Dime la cantidad vendida del producto: ");
        int cantidadVendida = Integer.parseInt(sc.nextLine());

        System.out.println("Dime la fecha de venta del producto: ");
        String fechaVenta = sc.nextLine();


        try {
            File file = new File("Ventas.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

            String cadena = idVentas + "|" + cantidadVendida + ";" + fechaVenta;

            bw.write(cadena);
            bw.newLine();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void calcularIngresos(Scanner sc) {
        System.out.println("Dime el nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.println("Dime la referencia del producto: ");
        String referencia = sc.nextLine();

        int productoId = sacarId(nombre,referencia);

        double suma = 0;
        try {
            File fileVentas = new File("Ventas.txt");
            BufferedReader brVentas = new BufferedReader(new FileReader(fileVentas));


            String lineaVentas;
            double precio = sacarPrecio(nombre,  referencia);

            while ((lineaVentas = brVentas.readLine()) != null) {
                String[] partes = lineaVentas.split("\\|");
                String[] venta = partes[1].split(";");

                if (Integer.parseInt(partes[0]) == productoId) {
                    double cantidadVendida = Double.parseDouble(venta[0]);
                    suma += cantidadVendida;

                    Double ingresoTotal = suma * precio;
                    System.out.println("Los ingresos totales son: " + ingresoTotal);

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double sacarPrecio(String nombre, String referencia) {
        try {
            File file = new File("Productos.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");

                if (nombre.equals(partes[1]) & referencia.equals(partes[2])) {
                    return Double.parseDouble(partes[3]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
