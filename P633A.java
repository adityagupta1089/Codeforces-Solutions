import java.util.Scanner;

public class ProblemA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		for (int i = 0; i < b && a * i <= c; i++) {
			if ((c - a * i) % b == 0) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");
		sc.close();
	}
}
