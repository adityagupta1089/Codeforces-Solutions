import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int z = 0;
	String pew = "";
	String x = "";
	for (int i = 0; i < n; i++) {
	    x = sc.next();
	    if (x.charAt(0) == '0') {
		System.out.println("0");
		break;
	    }
	    if (beautiful(x)) {
		z += x.length() - 1;
	    } else {
		pew = x;
	    }
	}
	if (x.charAt(0) != '0') {
	    if (!pew.equals(""))
		System.out.print(pew);
	    else
		System.out.print("1");
	    for (int i = 0; i < z; i++)
		System.out.print("0");
	}
	sc.close();
    }

    private static boolean beautiful(String x) {
	if (x.charAt(0) != '1')
	    return false;
	else
	    for (char c : x.substring(1).toCharArray())
		if (c != '0')
		    return false;
	return true;
    }
}
