import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class C670 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
	int n = sc.nextInt();
	Map<Integer, Integer> count = new HashMap<>();
	for (int i = 0; i < n; i++) {
	    int ind = sc.nextInt();
	    if (count.containsKey(ind))
		count.put(ind, count.get(ind) + 1);
	    else
		count.put(ind, 1);
	}
	int m = sc.nextInt();
	Set<Integer> mostVeryPleased = new HashSet<>();
	int veryPleased = 0;
	for (int i = 0; i < m; i++) {
	    int audio_i = sc.nextInt();
	    if (!count.containsKey(audio_i))
		count.put(audio_i, 0);
	    if (count.get(audio_i) >= veryPleased) {
		if (!mostVeryPleased.isEmpty() && count.get(audio_i) != veryPleased)
		    mostVeryPleased.clear();
		mostVeryPleased.add(i + 1);
		veryPleased = count.get(audio_i);
	    }
	}
	if (mostVeryPleased.size() == 1) {
	    System.out.println(mostVeryPleased.iterator().next());
	} else {
	    int reqIndex = mostVeryPleased.iterator().next();
	    int almostPleased = 0;
	    for (int i = 0; i < m; i++) {
		int subs_i = sc.nextInt();
		if (count.containsKey(subs_i) && count.get(subs_i) > almostPleased && mostVeryPleased.contains(i + 1)) {
		    almostPleased = count.get(subs_i);
		    reqIndex = i + 1;
		}
	    }
	    System.out.println(reqIndex);
	}
    }

}
