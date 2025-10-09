import java.io.File;
import java.io.FileWriter;

public class WriteFileExample {
    public static void main(String[] args) {
        try {
            File file = new File("text2.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write("Hola me llamo Adrian\n");
            fw.close();
            System.out.println("Escritura realizada");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
