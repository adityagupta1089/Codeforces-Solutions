import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger[] a = new BigInteger[n];
		for (int i = 0; i < n; i++) {
			a[i] = new BigInteger(sc.next());
		}
		sc.close();
		Arrays.sort(a);
		BigInteger num1 = BigInteger.ZERO;
		BigInteger sum = BigInteger.ZERO;
		for (int i = n - 1; i >= 0; i--) {
			if (a[i].mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
				sum = sum.add(a[i]);
			} else {
				if (!num1.equals(BigInteger.ZERO)) {
					sum = sum.add(num1.add(a[i]));
					num1 = BigInteger.ZERO;
				} else {
					num1 = a[i];
				}
			}
		}
		System.out.println(sum);
	}

}
