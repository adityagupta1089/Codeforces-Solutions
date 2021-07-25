import java.util.Arrays;
import java.util.Scanner;

public class P653A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		Arrays.sort(b);
		for (int i = 0; i + 2 < n; i++) {
			for (int j = i + 1; j + 1 < n && b[j] - b[i] <= 2 && b[j] != b[i]; j++) {
				for (int k = j + 1; k < n && b[k] - b[i] <= 2 && b[k] != b[j]; ) {
					System.out.println("YES");
					sc.close();
					return;
				}
			}
		}
		System.out.println("NO");
		sc.close();
	}
}
