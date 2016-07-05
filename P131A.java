import java.util.Scanner;

public class Problem131A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		sc.close();
		char[] y = x.toCharArray();
		boolean allcaps = true;
		boolean firstsmallrestcaps = true;
		for (int i = 0; i < y.length; i++) {
			if (allcaps) {
				if ('a' <= y[i] && y[i] <= 'z') {
					allcaps = false;
				}
			}
			if (firstsmallrestcaps) {
				if (i == 0 && 'A' <= y[i] && y[i] <= 'Z') {
					firstsmallrestcaps = false;
				} else if (i != 0 && 'a' <= y[i] && y[i] <= 'z') {
					firstsmallrestcaps = false;
				}
			}
		}
		if (allcaps || firstsmallrestcaps) {
			for (int i = 0; i < y.length; i++) {
				if (y[i] >= 'A' && y[i] <= 'Z') {
					y[i] = (char) (y[i] + 'a' - 'A');
				} else {
					y[i] = (char) (y[i] + 'A' - 'a');
				}
			}
		}
		System.out.println(y);
	}
}
