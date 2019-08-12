import java.util.Scanner;

public class P610A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// n=2a+2b=>n/2=a+b =
		// (1,n/2-1),(2,n/2-2),...(x,n/2-x)
		// x<n/2-x=>x<n/4
		if (n < 6 || n % 2 != 0)
			System.out.println("0");
		else {
			int m = n / 2;
			// if m is even 1,m;2,m-1,...m/2,m/2
			if (m % 2 == 0)
				System.out.println(m / 2 - 1);
			else
				System.out.println(m / 2);
		}
		sc.close();
	}
}
