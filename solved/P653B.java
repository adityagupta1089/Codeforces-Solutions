import java.util.ArrayList;
import java.util.Scanner;

public class P653B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		@SuppressWarnings("unchecked")
		ArrayList<String>[] ba = new ArrayList[6];
		for (int i = 0; i < 6; i++) {
			ba[i] = new ArrayList<String>();
		}
		for (int i = 0; i < q; i++) {
			String s = sc.next();
			char l = sc.next().charAt(0);
			ba[l - 'a'].add(s);
		}
		System.out.println(result(ba, 0, n - 1));
		sc.close();
	}

	private static long result(ArrayList<String>[] ba, int y, int x) {
		if (x == 1) {
			return ba[y].size();
		} else {
			long result = 0;
			for (String s : ba[y]) {
				result += result(ba, s.charAt(0) - 'a', x - 1);
			}
			return result;
		}
	}
}
