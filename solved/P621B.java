import java.util.Scanner;

public class P621B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		int[] di14 = new int[1000 * 2 - 1];
		int[] di23 = new int[1000 * 2 - 1];
		int count = 0;
		for (int i = 0; i < n; i++) {
			di14[999 - x[i] + y[i]] += 1;
			di23[x[i] + y[i] - 2] += 1;
		}
		for (int i = 0; i < di14.length; i++) {
			if (di14[i] >= 2) {
				count += di14[i] * (di14[i] - 1) / 2;
			}
			if (di23[i] >= 2) {
				count += di23[i] * (di23[i] - 1) / 2;
			}
		}
		System.out.println(count);
		sc.close();
	}
}
