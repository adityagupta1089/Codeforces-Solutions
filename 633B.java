import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.close();
		int t = 0;
		List<Integer> nums = new ArrayList<>();
		for (int i = 1;; i++) {
			int x = 0;
			int d = 5;
			while (d <= i) {
				x += Math.floor(i / d);
				d *= 5;
			}
			if (x == k) {
				++t;
				nums.add(i);
			} else if (x > k) {
				break;
			}
		}
		System.out.println(t);
		for (int i = 0; i < nums.size(); i++) {
			System.out.print(nums.get(i) + " ");
		}
	}
}
