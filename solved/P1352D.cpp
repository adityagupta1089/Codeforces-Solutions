#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int t, n;
    cin >> t;
    while (t--) {
        cin >> n;
        int v[n];
        for (int i = 0; i < n; i++) {
            cin >> v[i];
        }
        int a = 0, b = 0, l = 0, r = 0, i = 0, j = n - 1, m = 0;
        while (i <= j) {
            while (l <= r && i <= j) {
                l += v[i++];
            }
            a += l;
            if (l > 0) m++;
            r = 0;
            while (r <= l && i <= j) {
                r += v[j--];
            }
            b += r;
            if (r > 0) m++;
            l = 0;
        }
        printf("%d %d %d\n", m, a, b);
    }
    return 0;
}