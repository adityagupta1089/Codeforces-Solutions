import java.util.Arrays;
import java.util.Scanner;

public class P492B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		double d = Math.max(a[0], l - a[n - 1]);
		for (int i = 0; i < n - 1; i++) {
			d = Math.max((a[i + 1] - a[i]) / 2.0, d);
		}
		System.out.println(d);
		sc.close();
	}
}
