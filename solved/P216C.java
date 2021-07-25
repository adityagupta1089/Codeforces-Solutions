import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P216C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		List<Integer> sol = new ArrayList<>();
		int[] workers = new int[n + m];
		int curr = 0;
		while (curr < n + m) {
			int cnt = Math.max(0, k - workers[curr]);
			if (curr != 0 && cnt == 0 && curr + 1 < n + m && workers[curr + 1] == 0)
				cnt++;
			for (int i = 0; i < cnt; i++) {
				sol.add(curr + 1);
			}
			for (int j = curr; j < Math.min(n + m, curr + n); j++) {
				workers[j] += cnt;
			}
			curr++;
		}
		int last = sol.get(sol.size() - 1) - 1;
		if (last + n - 1 < n + m && workers[last + n - 1] == 1) {
			sol.add((n + m - 1) + 1);
		}
		System.out.println(sol.size());
		for (int i = 0; i < sol.size(); i++)
			System.out.print(sol.get(i) + " ");
		System.out.println();
		sc.close();
	}
}
