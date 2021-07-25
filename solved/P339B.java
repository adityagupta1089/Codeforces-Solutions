import java.util.Scanner;

public class P339B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 2<=n<=10^5
		int m = sc.nextInt();// 1<=m<=10^5
		int[] a = new int[m];// 1<=s_i<=n<=10^5
		for (int i = 0; i < m; i++) {
			a[i] = sc.nextInt();
		}
		long s = 0;// s~n*m~10^10
		int c = 1;
		for (int x : a) {
			if (x > c) {
				s += x - c;
			} else if (x < c) {
				s += n + x - c;
			}
			c = x;
		}
		System.out.println(s);
		sc.close();
	}
}
