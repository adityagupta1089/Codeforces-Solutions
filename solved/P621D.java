import java.util.Scanner;

public class P621D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] exp = new String[] { "x^y^z", "x^z^y", "(x^y)^z", "y^x^z", "y^z^x", "(y^x)^z", "z^x^y", "z^y^x",
				"(z^x)^y" };
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double z = sc.nextDouble();
		double[] val = new double[exp.length];
		boolean minv = false;
		if (x <= 1 && y <= 1 && z <= 1) {
			minv = true;
		}
		double def = (minv) ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
		val[0] = (x > 1 || minv) ? z * Math.log(y) + Math.log(Math.log((x < 1) ? 1 / x : x)) : def;
		val[1] = (x > 1 || minv) ? y * Math.log(z) + Math.log(Math.log((x < 1) ? 1 / x : x)) : def;
		val[2] = (x > 1 || minv) ? Math.log(y) + Math.log(z) + Math.log(Math.log((x < 1) ? 1 / x : x)) : def;
		val[3] = (y > 1 || minv) ? z * Math.log(x) + Math.log(Math.log((y < 1) ? 1 / y : y)) : def;
		val[4] = (y > 1 || minv) ? x * Math.log(z) + Math.log(Math.log((y < 1) ? 1 / y : y)) : def;
		val[5] = (y > 1 || minv) ? Math.log(x) + Math.log(z) + Math.log(Math.log((y < 1) ? 1 / y : y)) : def;
		val[6] = (z > 1 || minv) ? y * Math.log(x) + Math.log(Math.log((z < 1) ? 1 / z : z)) : def;
		val[7] = (z > 1 || minv) ? x * Math.log(y) + Math.log(Math.log((z < 1) ? 1 / z : z)) : def;
		val[8] = (z > 1 || minv) ? Math.log(x) + Math.log(y) + Math.log(Math.log((z < 1) ? 1 / z : z)) : def;
		double max = Double.NEGATIVE_INFINITY;
		int corri = 0;
		double min = Double.POSITIVE_INFINITY;
		for (int i = 0; i < val.length; i++) {
			if (!minv) {
				if (val[i] > max) {
					max = val[i];
					corri = i;
				}
			} else {
				if (val[i] < min) {
					min = val[i];
					corri = i;
				}
			}
		}
		System.out.println(exp[corri]);
		sc.close();
	}
}
