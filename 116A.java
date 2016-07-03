import java.util.Scanner;

public class Problem116A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			c -= a;
			c += b;
			if (c > max) {
				max = c;
			}
		}
		System.out.println(max);
	}
}
