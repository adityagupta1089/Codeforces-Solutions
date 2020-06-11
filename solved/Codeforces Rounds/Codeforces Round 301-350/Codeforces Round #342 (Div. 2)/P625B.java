import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P625B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String g = sc.next();
		String t = sc.next();
		sc.close();
		int count = 0;
		List<Integer> loc = new ArrayList<>();
		for (int i = 0; i + t.length() - 1 < g.length(); i++) {
			if (g.substring(i, i + t.length()).equals(t)) {
				loc.add(i);
			}
		}
		for (int i = 0; i < loc.size(); i++) {
			int k = 1;
			if (loc.size() >= 2) {
				int j = i + 1;
				for (; j < loc.size(); j++) {
					if (loc.get(i) + t.length() - 1 < loc.get(j)) {
						break;
					}
				}
				k = j - i;
			}
			++count;
			i += k - 1;
		}
		System.out.println(count);
	}
}
