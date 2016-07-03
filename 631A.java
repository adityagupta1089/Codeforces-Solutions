import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		int max = 0;
		for (int l = 0; l < n; l++) {
			for (int r = l; r < n; r++) {
				int c = f(a, l, r) + f(b, l, r);
				if (c > max) {
					max = c;
				}
			}
		}
		System.out.println(max);
		sc.close();
	}

	private static int f(int[] x, int l, int r) {
		int z = 0;
		for (int i = l; i <= r; i++) {
			z |= x[i];
		}
		return z;
	}
}
