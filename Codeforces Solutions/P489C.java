import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class P489C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int s = sc.nextInt();
		if ((s < 0 && m == 1) || (s < 1 && m > 1) || s > 9 * m) {
			System.out.println("-1 -1");
			sc.close();
			return;
		}
		List<Integer> max = new ArrayList<>();
		int n = 9, t = s;
		while (t != 0) {
			if (n <= t) {
				t -= n;
				max.add(n);
				n = 9;
			} else if (n > 0) {
				--n;
			}
		}
		while (max.size() < m) {
			max.add(0);
		}
		Stack<Integer> min = new Stack<>();
		int p = 0, u = s;
		int v = 0;
		while (u != 0) {
			int q = m - v - 1;
			if (q < 0) {
				q = 0;
			}
			if (9 * q >= u) {
				if (v == 0) {
					p = 1;
				} else {
					p = 0;
				}
			} else {
				p = u - 9 * q;
			}
			if (v >= m) {
				--v;
				u += min.peek();
				p = min.pop() + 1;
			}
			if (p <= u) {
				u -= p;
				min.push(p);
				++v;
			}
		}
		while (min.size() < m) {
			min.add(0);
		}
		String mins = "";
		String maxs = "";
		for (int i = 0; i < m; i++) {
			mins += min.get(i);
			maxs += max.get(i);
		}
		System.out.println(mins + " " + maxs);
		sc.close();
	}
}
