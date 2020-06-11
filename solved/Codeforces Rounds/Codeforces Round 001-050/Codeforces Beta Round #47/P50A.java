import java.util.Scanner;

public class P50A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		if (m * n >= 2)
			System.out.println(m * n / 2);
		else
			System.out.println(0);
		sc.close();
	}
}
