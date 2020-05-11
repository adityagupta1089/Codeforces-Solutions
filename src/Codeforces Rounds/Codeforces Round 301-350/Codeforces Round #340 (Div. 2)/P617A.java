import java.util.Scanner;

public class P617A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println((n / 5 + ((n % 5 != 0) ? 1 : 0)));
		sc.close();
	}

}
