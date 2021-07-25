import java.util.Scanner;

public class P266A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		String x = sc.next();
		char[] y = x.toCharArray();
		int val = 0;
		for (int i = 1; i < y.length; i++) {
			if (y[i] == y[i - 1]) {
				++val;
			}
		}
		sc.close();
		System.out.println(val);
	}
}
