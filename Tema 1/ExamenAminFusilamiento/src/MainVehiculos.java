import java.io.*;
import java.util.Scanner;

public class MainVehiculos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("0.- Salir del programa");
            System.out.println("1.- Anadir Vehiculos");
            System.out.println("2.- Consultar Estado");
            System.out.println("3.- Registrar Alquiler");
            System.out.println("4.- Registrar Devolucion");

            System.out.println("Dime que opcion quieres ejecutar: ");
            option = Integer.parseInt(sc.nextLine());

            if (option == 1) {
                anadirVehiculo(sc);
            } else if (option ==2) {
                consultarVehiculo(sc);
            } else if (option == 3) {
                registrarAlquiler(sc);
            } else if (option == 4) {
                registrarDevolucion(sc);
            }
        } while (option != 0);
    }

    public static void anadirVehiculo(Scanner sc) {

        int opcion = 0;
        do {
            int id = 1;

            System.out.println("Dime el modelo la matricula del vehiculo: ");
            String matricula = sc.nextLine();

            System.out.println("Dime el modelo del vehiculo: ");
            String modelo = sc.nextLine();

            System.out.println("Dime la tarifa diaria del alquiler: ");
            double tarifaDiaria = Double.parseDouble(sc.nextLine());

            System.out.println("Dime el estado inicial del vehiculo(Disponible o Alquilado): ");
            String estadoInicial = sc.nextLine();

            try {
                File file = new File("Vehiculos.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                BufferedReader br = new BufferedReader(new FileReader(file));


                String linea;

                while ((linea = br.readLine()) != null) {
                    id++;
                }

                String cadena = id + "|" + matricula + "|" + modelo + "|" + tarifaDiaria + "|" + estadoInicial;

                bw.write(cadena);
                bw.newLine();

                br.close();
                bw.close();

                System.out.println("Quieres anadir mas vehiculos pulsa 1 o si quieres salir pulsa 0: ");
                opcion = Integer.parseInt(sc.nextLine());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }  while (opcion != 0);
    }

    public static String sacarEstado(String matricula, String modelo) {

        try {
            File file = new File("Vehiculos.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");

                if (matricula.equals(partes[1]) & modelo.equals(partes[2])) {
                    return partes[4];
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String sacarTarifaDiaria(String matricula, String modelo) {

        try {
            File file = new File("Vehiculos.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");

                if (matricula.equals(partes[1]) & modelo.equals(partes[2])) {
                    return partes[3];
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void consultarVehiculo(Scanner sc) {
        System.out.println("Dime el modelo la matricula del vehiculo: ");
        String matricula = sc.nextLine();

        System.out.println("Dime el modelo del vehiculo: ");
        String modelo = sc.nextLine();

        System.out.println("El vehiculo solicitado es: '" + modelo + "' con matricula '" + matricula + "' con una " + sacarEstado(matricula, modelo));

    }


    public static int obtenerId(String matricula, String modelo) {
        try {
            File file = new File("Vehiculos.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");

                if (matricula.equals(partes[1]) & modelo.equals(partes[2])) {
                    return Integer.parseInt(partes[0]);
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static void registrarAlquiler(Scanner sc) {
        System.out.println("Dime el modelo la matricula del vehiculo: ");
        String matricula = sc.nextLine();

        System.out.println("Dime el modelo del vehiculo: ");
        String modelo = sc.nextLine();

        System.out.println("La id del vehiculo " + modelo + " = " + obtenerId(matricula, modelo));

        try {
            File file = new File("Vehiculos.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            File fileEscritura = new File("Movimientos.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileEscritura, true));

            String linea;
            int idObtenido = obtenerId(matricula, modelo);
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (idObtenido == Integer.parseInt(partes[0])) {
                    if ("Disponible" == sacarEstado(matricula, modelo)) {
                        System.out.println("Se puede registrar");
                    } else {
                        System.out.println("Este ya esta alquilado");
                        break;
                    }
                } else {
                    System.out.println("No existe esta id en la base de datos");
                }
            }

            System.out.println("Tipo de movimiento (Alquiler): ");
            String movimiento = sc.nextLine();

            System.out.println("Dime el nombre del cliente: ");
            String nombreCliente = sc.nextLine();

            System.out.println("Dime la fecha de inicio: ");
            String fechaInicio = sc.nextLine();

            String cadena = idObtenido + "|" + movimiento + "|" + nombreCliente + "|" + fechaInicio;

            bw.write(cadena);
            bw.newLine();

            bw.close();
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registrarDevolucion(Scanner sc) {

    }
}
