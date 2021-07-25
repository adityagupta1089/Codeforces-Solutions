import java.util.Scanner;

public class P282A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			sc.nextLine();
			if (str.equals("++X")) {
				++x;
			} else if (str.equals("--X")) {
				--x;
			} else if (str.equals("X++")) {
				x++;
			} else if (str.equals("X--")) {
				x--;
			}
		}
		System.out.println(x);
		sc.close();
	}

}
