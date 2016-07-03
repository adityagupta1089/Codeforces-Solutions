import java.util.Scanner;

public class ProblemA {
	enum AppleType {
		half, halfplus
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		AppleType[] s = new AppleType[n];
		for (int i = 0; i < n; i++) {
			if (sc.next().equals("half")) {
				s[i] = AppleType.half;
			} else {
				s[i] = AppleType.halfplus;
			}
		}
		sc.close();
		long apples = 0;
		long giftapples = 0;
		for (int i = n - 1; i >= 0; i--) {
			switch (s[i]) {
			case half:
				apples *= 2;
				break;
			case halfplus:
				apples *= 2;
				apples += 1;
				giftapples += 1;
				break;
			default:
				break;
			}
		}
		System.out.println(apples * p - giftapples * p / 2);
	}
}
