import java.util.Arrays;
import java.util.Random;

class Solution {
    public void sortColors(int[] a) {
        int n = a.length;
        int i = 0, j = 0, k = n - 1;
        while (j <= k) {
            if (a[j] == 0) {
                swap(a, i, j);
                i++;
                j++;
            } else if (a[j] == 2) {
                swap(a, j, k);
                k--;
            } else if (a[j] == 1) {
                j++;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 2, 2, 1, 2, 2, 1, 2, 1, 0};
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10; j++) {
                a[j] = r.nextInt(3);
            }
            int[] b = a.clone();
            new Solution().sortColors(a);
            boolean valid = true;
            for (int j = 0; j < 9; j++) {
                if (a[j] > a[j + 1]) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                System.out.printf("%s -> %s\n", Arrays.toString(b), Arrays.toString(a));
            }
        }
    }
}