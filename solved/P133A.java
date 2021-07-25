import java.util.Scanner;

public class P133A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		if (x.contains("H") || x.contains("Q") || x.contains("9")) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		sc.close();
	}
}
