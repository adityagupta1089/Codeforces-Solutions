import java.util.Scanner;

public class P266B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		String x = sc.next();
		char[] y = x.toCharArray();
		sc.close();
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (y[j] == 'B' && y[j + 1] == 'G') {
					y[j] = 'G';
					y[j + 1] = 'B';
					++j;
				}
			}
		}
		System.out.println(String.valueOf(y));
	}
}
