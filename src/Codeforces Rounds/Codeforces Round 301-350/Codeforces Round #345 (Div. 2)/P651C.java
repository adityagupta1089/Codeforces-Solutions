import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class P651C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// n~2e5
		Set<Point> p = new HashSet<>();
		Map<Point, Integer> dup = new HashMap<>();
		Map<Integer, Integer> xco = new HashMap<>();
		Map<Integer, Integer> yco = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Point np = new Point(x, y);
			int xo = 0, yo = 0;
			if (!p.contains(np)) {
				p.add(np);
			} else {
				if (!dup.containsKey(np))
					dup.put(np, 2);
				else
					dup.put(np, dup.get(np) + 1);
			}
			if (xco.containsKey(x))
				xo = xco.get(x);
			if (yco.containsKey(y))
				yo = yco.get(y);
			xco.put(x, xo + 1);
			yco.put(y, yo + 1);

		}
		long count = 0;// count~2e~10
		for (int xv : xco.keySet()) {
			long occ = xco.get(xv);
			count += occ * (occ - 1) / 2;
		}
		for (int yv : yco.keySet()) {
			long occ = yco.get(yv);
			count += occ * (occ - 1) / 2;
		}
		for (Point dp : dup.keySet()) {
			long dcy = dup.get(dp);
			count -= dcy * (dcy - 1) / 2;
		}
		System.out.println(count);
		sc.close();
	}

	static class Point {
		int x;
		int y;

		public Point(int a, int b) {
			x = a;
			y = b;
		}

		@Override
		public boolean equals(Object obj) {
			Point p2 = (Point) obj;
			return this.x == p2.x && this.y == p2.y;
		}

		@Override
		public int hashCode() {
			// // int max~2.1e9
			// int x2 = (x >= 0) ? 2 * x : -2 * x + 1;//x2~2e9
			// int y2 = (y >= 0) ? 2 * y : -2 * y + 1;//y2~2e9
			// long hc=(x2 + y2 + 1) * (x2 + y2) / 2 + x2;
			// return //~8e18
			int hash = 7;
			hash = 71 * hash + this.x;
			hash = 71 * hash + this.y;
			return hash;
		}

	}
}
