import java.util.Scanner;

public class P659A {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = num();
		int a = num();
		int b = num();
		int x = a + b;
		if (x < 0) {
			int k = -x / n;
			x += n * (k + 1);
		}
		x %= n;
		if (x == 0)
			x = n;
		print(x);
	}

	private static int num() {
		return sc.nextInt();
	}

	private static void print(Object x) {
		System.out.println(x);
	}
}
