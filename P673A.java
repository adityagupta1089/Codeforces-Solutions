import java.util.Scanner;

public class A673 {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int prev = 0;
	int curr = 0;
	for (int i = 0; i < n; i++) {
	    curr = sc.nextInt();
	    int delta = curr - prev - 1;
	    if (delta >= 15) {
		System.out.println(Math.min(prev + 15, 90));
		return;
	    }
	    prev = curr;
	}
	if (90 - curr - 1 >= 15) {
	    System.out.println(curr + 15);
	} else {
	    System.out.println(90);
	}
	sc.close();
    }
}
