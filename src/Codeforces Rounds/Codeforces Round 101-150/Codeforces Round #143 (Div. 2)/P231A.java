import java.util.Scanner;

public class P231A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int r = 0;
		for (int i = 0; i < t; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int p = sc.nextInt();
			if (m + n + p >= 2)
				r++;
		}
		System.out.println(r);
		sc.close();
	}
}
