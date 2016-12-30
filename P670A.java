import java.util.Scanner;

public class A670 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
	int n = sc.nextInt();
	int min = (2 * (n / 7 + 1) - 2) + ((n % 7 == 6) ? 1 : 0);
	int max = (2 * ((n - 1) / 7 + 1) - 1) + (((n - 1) % 7 != 0) ? 1 : 0);
	System.out.println(min + " " + max);
    }
}
