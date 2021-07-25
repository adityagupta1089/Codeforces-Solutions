import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P673B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Set<Integer> D1 = new HashSet<>();
		Set<Integer> D2 = new HashSet<>();
		int maxd2 = 0;
		int mind1 = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			int ui = sc.nextInt();
			int vi = sc.nextInt();
			int min = Math.min(ui, vi);
			int max = Math.max(ui, vi);
			if (!D2.contains(max) && !D1.contains(min)) {
				if (Math.min(mind1, max) <= Math.max(maxd2, min)) {
					System.out.println(0);
					sc.close();
					return;
				} else {
					D1.add(max);
					D2.add(min);
					mind1 = Math.min(max, mind1);
					maxd2 = Math.max(min, maxd2);
				}
			} else {
				System.out.println(0);
				sc.close();
				return;
			}
		}
		Set<Integer> bet = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			if (!D1.contains(i) && !D2.contains(i)) {
				if (maxd2 <= i && i <= mind1) {
					bet.add(i);
				} else if (i < maxd2) {
					D2.add(i);
					maxd2 = Math.max(i, maxd2);
				} else if (i > mind1) {
					D1.add(i);
					mind1 = Math.min(i, mind1);
				}
			}
		}
		int ways = bet.size() + 1;
		if (D1.size() == 0)
			ways -= 1;
		if (D2.size() == 0)
			ways -= 1;
		System.out.println(ways);
		sc.close();
	}
}
