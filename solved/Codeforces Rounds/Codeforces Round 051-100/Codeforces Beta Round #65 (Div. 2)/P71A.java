import java.util.Scanner;

public class P71A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			sc.nextLine();
			if (str.length() <= 10) {
				System.out.println(str);
			} else {
				System.out.println(str.charAt(0) + "" + (str.length() - 2) + "" + str.charAt(str.length() - 1));
			}
		}
		sc.close();
	}

}
