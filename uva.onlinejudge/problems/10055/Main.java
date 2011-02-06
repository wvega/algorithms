
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/* 10055 - Hashmat The Brave Soldier */

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        String parts[] = null;

        while ((line = reader.readLine()) != null) {
            parts = line.split(" ");
            if (parts.length == 2) {
                System.out.println(Math.abs(Long.valueOf(parts[0]) - Long.valueOf(parts[1])));
            }
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