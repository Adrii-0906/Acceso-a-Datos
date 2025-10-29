import java.io.*;

public class EjemploWriteRead {
    // Creamos un fichero en el que escribimos 3 lineas y luego las leemos

    public static void main(String[] args) {
        //ficheros();
        //binarios_simples();
    }

    public static void ficheros() {

        try {
            // Creamos el fichero llamado ejemplo.txt
            File file = new File("ejemplo.txt");

            // Con el if/else vemos si podemos crear el fichero o ya esta creado
            if (file.createNewFile()) {
                System.out.println("Archivo creado");
            } else {
                System.out.println("No se a podido crear un fichero");
            }

            // Ahora para escribir en el fichero usamos FileWriter
            FileWriter fw = new FileWriter(file, true);
            fw.write("Linea 1\n");
            fw.write("Linea 2\n");
            fw.write("Linea 3");

            System.out.println("Escritura realizada");
            fw.close();

            // Ahora leemos el fichero utilizano BufferReader
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;
            while ((linea= br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void binarios_simples() {
        String fichero = "datos.bin";
        // Escribimos en el fichero binario
        try {
            FileOutputStream fos = new FileOutputStream(fichero);
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeInt(25);
            dos.writeDouble(6.5);
            dos.writeUTF("Esto es Acceso a Datos");


            dos.close();
            fos.close();

            System.out.println("Datos escritos correctamente");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ahora vamos a leer los datos binarios

        try {
            FileInputStream fis = new FileInputStream(fichero);
            DataInputStream dis = new DataInputStream(fis);

            int edad = dis.readInt();
            double pi = dis.readDouble();
            String saludo = dis.readUTF();

            dis.close();
            fis.close();

            System.out.println("Entero leido: " + edad);
            System.out.println("Double leido: " + pi);
            System.out.println("Saludo leido: " + saludo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void binarios_bucle() {
        String fichero = "alumnos.dat";
    }
}

