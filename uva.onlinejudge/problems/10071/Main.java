
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/* 10071 - Back to High School Physics */

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        String parts[] = null;

        while ((line = reader.readLine()) != null) {
            parts = line.split(" ");
            System.out.println(Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]) * 2);
        }
    }

    public static void main(String args[]) {
        try {
            (new Main()).run();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}