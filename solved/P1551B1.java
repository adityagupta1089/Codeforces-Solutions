import java.util.*;

public class P1551B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            int[] counts = new int[26];
            String s = sc.nextLine();
            for (char c : s.toCharArray()) {
                counts[c - 'a']++;
            }
            int c1 = 0, c2 = 0;
            for (int x : counts) {
                if (x == 1) {
                    c1++;
                } else if (x >= 2) {
                    c2++;
                }
            }
            System.out.println(c1 / 2 + c2);
        }
    }
}
