#include <iostream>
#include <queue>
using namespace std;

bool possible(int* a, int n, int p) {
    int cnt = 1, v = a[p], nearest = p, nearest_dis = 2 * n, mid = (n - 1) / 2;
    while (cnt <= n) {
        int mx = 0, be = 0, ab = 0, eq = 1;
        for (int i = 1; p - i >= 0 || p + i < n; i++) {
            // printf("i=%d\n", i);
            if (p - i >= 0) {
                int d = a[p - i];
                if (abs(p - i - mid) < nearest_dis) {
                    nearest_dis = abs(p - i - mid);
                    nearest = p - i;
                }
                if (d < v) {
                    be++;
                } else if (d == v) {
                    eq++;
                } else {
                    ab++;
                }
            }
            if (p + i < n) {
                int u = a[p + i];
                if (abs(p + i - mid) < nearest_dis) {
                    nearest_dis = abs(p + i - mid);
                    nearest = p + i;
                }

                if (u < v) {
                    be++;
                } else if (u == v) {
                    eq++;
                } else {
                    ab++;
                }
            }
            // printf("p=%d, i=%d, be=%d, eq=%d, ab=%d\n", p, i, be, eq, ab);
            int m = (be + eq + ab + 1) / 2;
            // printf("m=%d\n", m);
            if (m > be && m <= be + eq) {
                mx = max(mx, i);
                // printf("mx=%d\n", mx);
            }
        }
        int sz = min(n - 1, p + mx) - max(0, p - mx) + 1;
        if (sz > cnt) {
            // printf("median at p=%d (v=%d) size %d [be=%d, ab=%d, eq=%d]\n",
            // p,
            //    v, sz, be, ab, eq);
            for (int i = max(p - mx, 0); i <= min(p + mx, n - 1); i++) {
                a[i] = v;
            }
            // cout << "a = ";
            // for (int i = 0; i < n; i++) {
            // cout << a[i] << "(" << i << ") ";
            // }
            // cout << "\n";
            cnt = sz;
            p = nearest;
            // printf("shifted to p=%d\n", p);
        } else {
            break;
        }
    }
    return cnt >= n;
}

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        // printf("***\n");
        int n, k;
        cin >> n >> k;
        int a[n];
        queue<int> locs;
        for (int i = 0; i < n; i++) {
            cin >> a[i];
            if (a[i] == k) {
                locs.push(i);
            }
        }
        bool valid = false;
        while (!locs.empty()) {
            int front = locs.front();
            locs.pop();
            if (possible(a, n, front)) {
                valid = true;
                cout << "yes\n";
                break;
            }
        }
        if (!valid) {
            cout << "no\n";
        }
    }
    return 0;
}