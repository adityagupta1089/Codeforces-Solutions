import java.util.Scanner;

public class P664A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		String[] x = sc.nextLine().split(" ");
		String a = x[0];
		String b = x[1];
		if (a.equals(b))
			System.out.println(a);
		else
			System.out.println("1");
		sc.close();
	}
}