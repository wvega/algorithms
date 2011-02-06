
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/* 494 - Kindergarten Counting Game */

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        String parts[];
        char sequence[];

        while((line = reader.readLine()) != null) {
            sequence = line.toCharArray();
            for (int i = sequence.length - 1; i > 0; i--) {
                if (!(Character.isLowerCase(sequence[i]) || Character.isUpperCase(sequence[i]))) {
                    sequence[i] = ' ';
                }
            }
            System.out.println(new String(sequence).split(" +").length);
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