import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	sc.nextLine();
	Map<String, String> mp = new HashMap<>();
	for (int i = 0; i < m; i++) {
	    String s1 = sc.next();
	    String s2 = sc.next();
	    mp.put(s1, (s1.length() <= s2.length()) ? s1 : s2);
	    sc.nextLine();
	}
	for (int i = 0; i < n; i++) {
	    System.out.print(mp.get(sc.next()) + " ");
	}
    }
}
