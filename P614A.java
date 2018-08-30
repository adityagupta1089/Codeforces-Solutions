import java.math.BigInteger;
import java.util.Scanner;

public class P614A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long l = sc.nextLong();// 1-1e18
		long r = sc.nextLong();// 1-1e18
		long k = sc.nextInt();// 2-1e9
		boolean printed = false;
		BigInteger v = BigInteger.ONE;
		for (; v.compareTo(BigInteger.valueOf(r)) <= 0; v = v.multiply(BigInteger.valueOf(k))) {
			if (v.compareTo(BigInteger.valueOf(l)) >= 0) {
				printed = true;
				System.out.print(v + " ");
			}
		}
		if (!printed)
			System.out.println("-1");
		sc.close();
	}

}
