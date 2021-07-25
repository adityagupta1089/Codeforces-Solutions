import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemA {
    public static void main(String[] args) {

        BufferedReader br;
        String line = "";
        try {
            br = new BufferedReader(new FileReader("a.in"));
            line = br.readLine();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringTokenizer st = new StringTokenizer(line);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int keya = keyNumber(a);
        int keyb = keyNumber(b);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("a.out");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (keya > keyb) {
            pw.println("a");
        } else {
            pw.println("b");
        }
        pw.close();
    }

    private static int keyNumber(int x) {
        int sum = 0;
        int max = 0;
        for (int i = 2; i <= x; i++) {
            if (isPrime(i) && x % i == 0) {
                sum += i;
                if (i > max) {
                    max = i;
                }
            }

        }
        return 2 * max - sum;
    }

    private static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        if (x == 2) {
            return true;
        }
        if (x % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
