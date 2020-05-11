import java.util.Arrays;
import java.util.Scanner;

public class P745D {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int v = 1;
		while (v < n)
			v *= 2;
		int[] min = new int[v];
		Arrays.fill(min, Integer.MAX_VALUE);
		int v2 = v / 2;
		while (v2 != 0) {
			int cnt = 0;
			for (int i = 0; i < n; i++)
				if ((i / v2) % 2 == 0)
					cnt++;
			System.out.println(cnt);
			System.out.flush();
			for (int i = 0; i < n; i++) {
				if ((i / v2) % 2 == 0) {
					System.out.print((i + 1) + " ");
					System.out.flush();
				}
			}
			System.out.println();
			System.out.flush();
			for (int i = 0; i < n; i++) {
				int x = in.nextInt();
				if ((i / v2) % 2 == 1) {
					min[i] = Math.min(min[i], x);
				}
			}
			cnt = 0;
			for (int i = 0; i < n; i++)
				if ((i / v2) % 2 == 1)
					cnt++;
			System.out.println(cnt);
			for (int i = 0; i < n; i++) {
				if ((i / v2) % 2 == 1) {
					System.out.print((i + 1) + " ");
					System.out.flush();
				}
			}
			System.out.println();
			System.out.flush();
			for (int i = 0; i < n; i++) {
				int x = in.nextInt();
				if ((i / v2) % 2 == 0) {
					min[i] = Math.min(min[i], x);
				}
			}
			v2 /= 2;
		}
		in.close();
		System.out.println(-1);
		System.out.flush();
		for (int i = 0; i < n; i++) {
			System.out.print(min[i] + " ");
			System.out.flush();
		}
		System.out.println();
		System.out.flush();

	}

}
