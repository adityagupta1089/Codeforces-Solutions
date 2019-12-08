#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct trap {
    int l;
    int r;
    int d;
};


int get_time(int min_agi, vector<trap> &ts, int n) {
    // a[i] < d -> die
    int cl = -1, cr = -1;
    int tot = 0;
    for (trap t: ts) {
        if (t.d > min_agi) {
            if (cl == -1) {
                cl = t.l;
                cr = t.r;
            } else {
                if (t.l <= cr) {
                    cr = max(cr, t.r);
                } else {
                    tot += cr - cl + 1;
                    cl = t.l;
                    cr = t.r;
                }
            }
        }
    }
    if (cl != -1)
        tot += cr - cl + 1;
    return 2 * tot + n + 1;
}

int main() {
    int m, n, k, t;
    vector<int> a;
    vector<trap> ts;
    scanf("%d %d %d %d", &m, &n, &k, &t);
    a.resize(m);
    ts.resize(k);
    for (int i = 0; i < m; i++) {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < k; i++) {
        int l, r, d;
        scanf("%d %d %d", &l, &r, &d);
        ts[i] = {l, r, d};
    }
    sort(a.begin(), a.end());
    sort(ts.begin(), ts.end(), [](trap t1, trap t2) -> bool {
        return ((t1.l != t2.l) ? (t1.l < t2.l) : (t1.r < t2.r));
    });
    int lo = 0, hi = m - 1;
    int ans = m;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
//        printf("[%d, %d]: %d -> %d\n", lo, hi, mid, get_time(a[mid], ts, n));
        if (get_time(a[mid], ts, n) > t) {
            lo = mid + 1;
        } else {
            ans = mid;
            hi = mid - 1;
        }
    }
    printf("%d", m - ans);
}