import java.util.Scanner;

public class P1245B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int a = in.nextInt(); //R
            int b = in.nextInt(); //P
            int c = in.nextInt(); //S
            in.nextLine();
            String s = in.nextLine();
            int w = 0;
            char[] ans = new char[s.length()];
            int i = 0;
            for (char ch : s.toCharArray()) {
                if (ch == 'R' && b > 0) {
                    ans[i] = 'P';
                    b--;
                    w++;
                }
                if (ch == 'P' && c > 0) {
                    ans[i] = 'S';
                    c--;
                    w++;
                }
                if (ch == 'S' && a > 0) {
                    ans[i] = 'R';
                    a--;
                    w++;
                }
                i++;
            }
            if (w >= Math.round(n / 2.0)) {
                System.out.println("YES");
                for (char ch : ans) {
                    if (ch == 'P' || ch == 'S' || ch == 'R') {
                        System.out.print(ch);
                    } else if (a > 0) {
                        a--;
                        System.out.print('R');
                    } else if (b > 0) {
                        b--;
                        System.out.print('P');
                    } else {
                        c--;
                        System.out.print('S');
                    }
                }
                System.out.println();
            } else {
                System.out.println("NO");
            }
        }
    }
}