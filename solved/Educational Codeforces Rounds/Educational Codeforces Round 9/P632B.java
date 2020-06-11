import java.util.Scanner;

public class P632B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n];
		boolean[] t = new boolean[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		char[] inp = sc.next().toCharArray();
		sc.close();
		for (int i = 0; i < n; i++) {
			t[i] = inp[i] == 'B';
		}
		long strength_b = 0;
		for (int i = 0; i < n; i++) {
			strength_b += (t[i]) ? p[i] : 0;
		}
		long sb = strength_b;
		long max_s = strength_b;
		for (int i = 0; i < n; i++) {
			sb += p[i] * ((t[i]) ? -1 : 1);
			if (sb > max_s) {
				max_s = sb;
			}
		}
		sb = strength_b;
		for (int i = n - 1; i >= 0; i--) {
			sb += p[i] * ((t[i]) ? -1 : 1);
			if (sb > max_s) {
				max_s = sb;
			}
		}
		System.out.println(max_s);
	}
}
