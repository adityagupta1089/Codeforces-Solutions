import java.util.Scanner;

public class P112A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		String y = sc.next();
		char[] x1 = x.toCharArray();
		char[] y1 = y.toCharArray();
		for (int i = 0; i < x1.length; i++) {
			if (val(x1[i]) != val(y1[i])) {
				System.out.println(((val(x1[i]) - val(y1[i])) > 0) ? "1" : "-1");
				sc.close();
				return;
			}
		}
		System.out.println("0");
		sc.close();
	}

	private static int val(char x) {
		if ('a' <= x && x <= 'z') {
			return x - 'a';
		} else {
			return x - 'A';
		}
	}

}
