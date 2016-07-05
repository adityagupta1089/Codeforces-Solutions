import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();// ~1000
	List<List<Integer>> arrs = new ArrayList<>();
	for (int i = 0; i < n; i++) {
	    int a = sc.nextInt();
	    boolean added = false;
	    for (List<Integer> l : arrs) {
		if (!l.contains(a)) {
		    l.add(a);
		    added = true;
		    break;
		}
	    }
	    if (!added) {
		List<Integer> nl = new ArrayList<>();
		nl.add(a);
		arrs.add(nl);
	    }
	}
	int val = 0;// val~999
	for (List<Integer> l : arrs) {
	    // Collections.sort(l);
	    // System.out.println(l);
	    // System.out.println(l.size());
	    val += l.size() - 1;
	}
	System.out.println(val);
	sc.close();
    }
}
