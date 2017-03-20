import java.util.Scanner;

public class P429 {

private static long hcf(long a, long b) {
        if (a == 0)
                return b;
        else if (b == 0)
                return a;
        else {
                return hcf(b, a % b);
        }
}
private static long lcm(long a, long b) {
        // comment
        return a * b / hcf(a, b);
}
public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        long n;
        n=sc.nextLong();
        if (n == 1)
                System.out.println("1");
        else if (n == 2)
                System.out.println("2");
        else if (n == 3)
                System.out.println("6");
        else if (n % 2 != 0)
                System.out.println(n * (n - 1) * (n - 2) );
        else {
                long maxv = (n - 1) * (n - 2) * (n - 3);
                for (long v1 = n; v1 >= n - 10 && v1 >= 1; v1--) {
                        for (long v2 = v1 - 1; v2 >= n - 10 && v2 >= 1; v2--) {
                                for (long v3 = v2 - 1; v3 >= n - 10 && v3 >= 1; v3--) {
                                        long mcl = lcm(lcm(v1, v2), v3);
                                        if (mcl > maxv) {
                                                maxv = mcl;
                                        }
                                }
                        }
                }
                System.out.println(maxv);

        }

}

}
