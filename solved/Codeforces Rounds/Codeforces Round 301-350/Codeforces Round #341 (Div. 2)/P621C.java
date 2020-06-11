import java.math.BigDecimal;
import java.util.Scanner;

public class P621C {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		int[] l = new int[n];
		int[] r = new int[n];
		int[] w = new int[n];
		int[] ni = new int[n];
		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
			ni[i] = r[i] - l[i] + 1;
			w[i] = (int) (Math.floor(r[i] / p) - Math.floor((l[i] - 1) / p));
		}
		sc.close();
		// double vald = 0;
		BigDecimal vald = BigDecimal.ZERO;
		for (int i = 0; i < n; i++) {
			// vald += (double) (w[i] * ni[(i + 1) % n] + ni[i] * w[(i + 1) % n]
			// - w[i] * w[(i + 1) % n]) / (double) (ni[i] * ni[(i + 1) % n]);
			BigDecimal nn = b(ni[i]).multiply(b(ni[(i + 1) % n]));
			BigDecimal ww = b(w[i]).multiply(b(w[(i + 1) % n]));
			BigDecimal x1 = b(w[i]).multiply(b(ni[(i + 1) % n]));
			BigDecimal x2 = b(w[(i + 1) % n]).multiply(b(ni[i]));
			BigDecimal v = x1.add(x2).subtract(ww);
			vald = vald.add(v.divide(nn, 50, BigDecimal.ROUND_DOWN));
		}
		// System.out.println(vald * 2000);
		System.out.println(vald.multiply(b(2000)).toString());
	}

	private static BigDecimal b(long l) {
		return BigDecimal.valueOf(l);
	}
}
