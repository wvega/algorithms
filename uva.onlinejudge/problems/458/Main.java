
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/* 458 - The Decoder */

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        char sequence[];
        int n = 0;

        while((line = reader.readLine()) != null) {
            sequence = line.toCharArray();
            n = sequence.length;
            for (int i = 0; i < n; i++) {
                // Printable ASCII chars have int value within 32 and 126.
                // Let's map the interval I = [32, 126] to I' = [0, 95) so a char
                // with int value of 38 in I has a value of 6 in I'.
                // Now, to decode the message we need to substract 7 from each
                // char's int value. In our example a char with value 38 in I will
                // have a decoded value of -1 in I'. However, -1 is not in the
                // interval so we need to use use the mod operator to get a valid
                // value: -1 mod 95 = 94. Then we can add 32 to that value to map
                // it to a value in I: 94 + 32 = 126.
                sequence[i] = (char) (((sequence[i] - 32 - 7) % 95) + 32);
            }
            System.out.println(sequence);
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