import java.util.Scanner;

public class P651A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int c = 0;
		for (; x >= 1 && y >= 1; c++) {
			if (x <= y) {
				x += 1;
				y -= 2;
			} else if (y < x) {
				y += 1;
				x -= 2;
			}
			if (x < 0 || y < 0) {
				c -= 1;
			}
		}
		System.out.println(c);
		sc.close();
	}

}
