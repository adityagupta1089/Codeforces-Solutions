import java.util.Scanner;

public class P478B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();
		long a = n / m;
		long b = n % m;
		System.out.println((b * (a + 1) * a / 2 + (m - b) * a * (a - 1) / 2) + " " + (n - m + 1) * (n - m) / 2);
		sc.close();
	}
}
