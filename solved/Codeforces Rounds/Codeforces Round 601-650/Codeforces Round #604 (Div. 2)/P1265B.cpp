#ifdef ONLINE_JUDGE
#include <bits/stdc++.h>
#else

#define DEBUG 1

#include <iostream>

#endif

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int p[n];
        int pos[n + 1];
        fill(pos, pos + n + 1, 0);
        for (int i = 0; i < n; i++) {
            cin >> p[i];
            pos[p[i]] = i;
        }
        int mp = n + 1; //min pos
        int np = -1; //max pos
        bool ans[n];
        fill(ans, ans + n, false);
        for (int i = 1; i <= n; i++) {
            mp = min(mp, pos[i]);
            np = max(np, pos[i]);
            //            printf("%d -> [%d, %d]\n", i, mp, np);
            if (np - mp + 1 == i) {
                ans[i - 1] = true;
            }
        }
        for (bool b:ans) {
            printf("%d", b ? 1 : 0);
        }
        printf("\n");
    }
    return 0;
}