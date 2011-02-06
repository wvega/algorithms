import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/* 2704 - Pascal's Travels */

public class Main {

    private BufferedReader reader;

    public void run() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;

        while ((n = Integer.valueOf(reader.readLine())) != -1) {
            count(n);
        }
    }

    public void count(int n) throws IOException {
        long board[][] = new long[n][n];
        int steps[] = new int[3];
        char values[];
        long m, k;

        board[0][0] = 1;

        for (int r = 0; r < n; r++) {
            values = reader.readLine().toCharArray();
            for (int c = 0; c < n; c++) {
                if ((k = board[r][c]) > 0) {
                    // substract 48 from the ASCII value to get the int number
                    steps[0] = values[c] - 48;
                    // new position to the right
                    steps[1] = c + steps[0];
                    // new position to the bottom
                    steps[2] = r + steps[0];

                    if (steps[0] == 0) { continue; }

                    // if current vertex is included in k different paths,
                    // vertices adjacent to current vertex are included in
                    // k + m paths with m being the number of paths that already
                    // include each adjacent vertex.

                    if (steps[1] < n && (m = board[r][steps[1]]) > 0) {
                        board[r][steps[1]] = k + m;
                    } else if (steps[1] < n) {
                        board[r][steps[1]] = k;
                    }

                    if (steps[2] < n && (m = board[steps[2]][c]) > 0) {
                        board[steps[2]][c] = k + m;
                    } else if (steps[2] < n) {
                        board[steps[2]][c] = k;
                    }
                }
            }
        }

        if (board[n-1][n-1] > 0) {
            System.out.println(board[n-1][n-1]);
        } else {
            System.out.println(0);
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