import java.util.Scanner;

public class P118A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] chr = str.toCharArray();
		String str2 = "";
		for (int i = 0; i < chr.length; i++) {
			char c = chr[i];
			if (c >= 'A' && c <= 'Z') {
				c = (char) (c + 'a' - 'A');
			}
			if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'y') {
				str2 = str2 + "." + c;
			}
		}
		System.out.println(str2);
		sc.close();
	}
}
