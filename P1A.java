import java.util.Scanner;

public class P1A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int a = sc.nextInt();
		System.out.println((long) (Math.ceil((double) m / (double) a) * Math.ceil((double) n / (double) a)));
		sc.close();
	}
}
