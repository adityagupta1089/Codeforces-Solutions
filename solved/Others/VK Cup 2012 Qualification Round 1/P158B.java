import java.util.Scanner;

public class P158B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] c = new int[4];
		for (int i = 0; i < n; i++) {
			c[sc.nextInt() - 1]++;
		}
		int k = Math.min(c[2], c[0]);
		int t = c[3] + k;
		c[3] = 0;
		c[2] = c[2] - k;
		c[0] = c[0] - k;
		if (c[1] != 0) {
			t += c[1] / 2;
			c[1] %= 2;
		}
		if (c[2] == 0) {
			if (c[1] == 1) {
				if (c[0] >= 2) {
					c[0] -= 2;
				} else if (c[0] == 1) {
					c[0] -= 1;
				}
				c[1] = 0;

				t += 1;
			}
			t += c[0] / 4;
			c[0] %= 4;
			if (c[0] > 0) {
				t += 1;
				c[0] = 0;
			}
		} else if (c[0] == 0) {
			if (c[2] > 0) {
				t += c[2];
				c[2] = 0;
			}
			if (c[1] == 1) {
				c[1] = 0;
				t += 1;
			}
		}
		System.out.println(t);
		sc.close();
	}
}
