import java.util.Scanner;

public class P158A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] scores = new int[n];
		for (int i = 0; i < n; i++) {
			scores[i] = sc.nextInt();
		}
		int m = 0;
		for (int i = 0; i < n; i++) {
			if (scores[i] >= scores[k - 1] && scores[i] > 0) {
				m++;
			}
		}
		System.out.println(m);
		sc.close();
	}
}
