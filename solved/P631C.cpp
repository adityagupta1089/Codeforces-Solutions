#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    int a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    deque<pair<int, int>> q;
    int b[n];
    memset(b, 0, sizeof(b));
    for (int i = 0; i < m; i++) {
        int t, r;
        cin >> t >> r;
        r--;
        while (!q.empty() && q.back().second <= r) {
            q.pop_back();
        }
        if (q.empty() || q.back().first != t) q.emplace_back(t, r);
    }
    int t, r;
    t = q.front().first;
    r = q.front().second;
    q.pop_front();
    int pt = t, t0 = t;
    if (t == 1)
        sort(a, a + r + 1);
    else
        sort(a, a + r + 1, greater<>());
    int lo = 0, hi = n - 1;
    int nr = (q.empty()) ? -1 : q.front().second;
    for (int i = n - 1; i >= nr + 1; i--) {
        b[hi--] = a[i];
    }
    while (!q.empty()) {
        t = q.front().first, r = q.front().second;
        q.pop_front();
        if (t == pt) continue;
        pt = t;
        nr = (q.empty()) ? -1 : q.front().second;
        if (t == t0) {
            for (int i = r; i > nr; i--) b[i] = a[hi--];

        } else {
            for (int i = r; i > nr; i--) b[i] = a[lo++];
        }
    }
    for (int x : b) {
        printf("%d ", x);
    }
    printf("\n");
}