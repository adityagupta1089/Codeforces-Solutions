import java.util.Scanner;

public class P610B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		long min = 1000000000;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if (a[i] < min)
				min = a[i];
		}
		long sum = min * n;
		int prevminloc = -1;
		int firstminloc = -1;
		int deltaloc = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == min) {
				if (prevminloc != -1) {
					if (i - prevminloc - 1 > deltaloc) {
						deltaloc = i - prevminloc - 1;
					}
				} else {
					firstminloc = i;
				}
				prevminloc = i;
			}
		}
		if (firstminloc + n - prevminloc - 1 > deltaloc)
			deltaloc = firstminloc + n - prevminloc - 1;
		System.out.println(sum + deltaloc);
		sc.close();
	}
}
