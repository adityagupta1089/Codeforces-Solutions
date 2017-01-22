import java.util.Scanner;

public class Problem96A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		sc.close();
		char[] y = x.toCharArray();
		int z = y[0];
		int val = 1;
		for (int i = 1; i < y.length; i++) {
			if (y[i] == z) {
				++val;
				if (val >= 7) {
					System.out.println("YES");
					return;
				}
			} else {
				val = 1;
				z = y[i];
			}
		}
		System.out.println("NO");
	}
}
