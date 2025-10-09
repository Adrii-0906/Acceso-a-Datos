import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileExample {
    public static void main(String[] args) {
        try {
            File file = new File("text.txt");
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
}