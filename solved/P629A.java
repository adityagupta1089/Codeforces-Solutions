import java.util.Scanner;

public class P629A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] b = new boolean[n][n];
		long z = 0;
		int[] r = new int[2 * n];
		for (int i = 0; i < n; i++) {
			String x = sc.next();
			for (int j = 0; j < n; j++) {
				b[i][j] = x.charAt(j) == 'C';
				if (b[i][j]) {
					++r[i];
					++r[n + j];
				}
			}
		}
		sc.close();
		for (int x : r) {
			if (x > 1)
				z += (x - 1) * x / 2;
		}
		System.out.println(z);
	}
}
