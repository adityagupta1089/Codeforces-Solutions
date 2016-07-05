import java.util.Scanner;

public class B670 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
	sc.nextInt();// n
	long k = sc.nextLong();
	long r = (long) Math.ceil((Math.sqrt(1 + 8 * k) - 1) / 2);
	long p = r * (r - 1) / 2;
	long r2 = k - p;
	int x = 0;
	for (int i = 0; i < r2; i++)
	    x = sc.nextInt();
	System.out.println(x);
    }

}
