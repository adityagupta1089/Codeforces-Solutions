import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P374C {

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private final static int CYCLE = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] mat = new char[n][m];
		sc.nextLine();
		List<Point> ds = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < m; j++) {
				mat[i][j] = s.charAt(j);
				if (mat[i][j] == 'D')
					ds.add(new Point(i, j));
			}
		}
		boolean[][] visited = new boolean[n][m];
		int[][] cache = new int[n][m];
		for (int i = 0; i < n; i++)
			Arrays.fill(cache[i], -1);
		int maxval = 0;
		for (Point p : ds) {
			int val = dfs(p, mat, visited, n, m, cache);
			if (val == CYCLE) {
				System.out.println("Poor Inna!");
				sc.close();
				return;
			} else {
				cache[p.x][p.y] = val;
				maxval = Math.max(maxval, val);
			}
		}
		if (maxval > 0) {
			System.out.println(maxval);
		} else {
			System.out.println("Poor Dima!");
		}
		sc.close();
	}

	private static int dfs(Point p, char[][] mat, boolean[][] visited, int n, int m, int[][] cache) {
		if (visited[p.x][p.y]) {
			return CYCLE;
		} else if (cache[p.x][p.y] != -1) {
			return cache[p.x][p.y];
		} else {
			visited[p.x][p.y] = true;
			int currval = mat[p.x][p.y] == 'A' ? 1 : 0;
			int maxval = 0;
			for (Point q : new Point[] { new Point(p.x, p.y + 1), new Point(p.x, p.y - 1), new Point(p.x + 1, p.y),
					new Point(p.x - 1, p.y) }) {
				if (0 <= q.x && q.x < n && 0 <= q.y && q.y < m) {
					if (mat[q.x][q.y] == next(mat[p.x][p.y])) {
						int val = dfs(new Point(q.x, q.y), mat, visited, n, m, cache);
						if (val == CYCLE) {
							return CYCLE;
						} else {
							maxval = Math.max(maxval, val);
						}
					}
				}
			}
			visited[p.x][p.y] = false;
			cache[p.x][p.y] = maxval + currval;
			return cache[p.x][p.y];
		}
	}

	private static char next(char c) {
		switch (c) {
		case 'D':
			return 'I';
		case 'I':
			return 'M';
		case 'M':
			return 'A';
		default: /* case 'A' */
			return 'D';
		}
	}
}
