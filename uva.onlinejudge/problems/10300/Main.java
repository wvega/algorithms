
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/* 10300 - Ecological Premium */

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        String parts[] = null;
        long budget; int k;

        // number of test cases
        int n = Integer.valueOf(reader.readLine());

        for (int i = n; i > 0; i--) {
            budget = 0;
            // number of farmers per case
            k = Integer.valueOf(reader.readLine());
            for (int j = k; j > 0; j--) {
                line = reader.readLine();
                parts = line.split(" ");
                if (parts.length == 3) {
                    budget += Integer.valueOf(parts[0]) * Integer.valueOf(parts[2]);
                }
            }
            System.out.println(budget);
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