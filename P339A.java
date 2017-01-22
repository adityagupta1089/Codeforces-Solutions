import java.util.Arrays;
import java.util.Scanner;

public class Problem339A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(Arrays.stream(sc.next().split("\\+")).mapToInt(s -> Integer.parseInt(s)).sorted()
				.mapToObj(i -> String.valueOf(i)).reduce((a, b) -> a + "+" + b).get());
		sc.close();
	}
}
