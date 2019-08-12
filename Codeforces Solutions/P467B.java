import java.util.Scanner;

public class P467B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] x = new int[m + 1];
		for (int i = 0; i < m + 1; i++) {
			x[i] = sc.nextInt();
		}
		int u = 0;
		for (int i = 0; i < m; i++) {
			int f = x[i] ^ x[m];
			int s = 0;
			for (char c : Integer.toBinaryString(f).toCharArray()) {
				if (c == '1') {
					s++;
					if (s > k) {
						break;
					}
				}
			}
			if (s <= k)
				u++;
		}
		System.out.println(u);
		sc.close();
	}
}
