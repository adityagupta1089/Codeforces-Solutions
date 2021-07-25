import java.util.Scanner;

public class P451B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int l = -1;
		int r = -1;
		for (int i = 0; i < n; i++) {
			if (i < n - 1 && l == -1 && r == -1 && a[i] > a[i + 1]) {
				l = i + 1;
			} else if (i > 0 && a[i - 1] > a[i] && (i == n - 1 || a[i] < a[i + 1])) {
				r = i + 1;
				for (int j = i + 1; j < n - 1; j++) {
					if (a[j] > a[j + 1]) {
						System.out.println("no");
						sc.close();
						return;
					}
				}
			}
		}
		System.out
				.println(((l == -1 && r == -1) || ((l == 1 || (a[l - 2] < a[r - 1])) && (r == n || (a[l - 1] < a[r]))))
						? "yes\n" + ((l != -1) ? l : 1) + " " + ((r != -1) ? r : 1)
						: "no");
		sc.close();
	}
}
