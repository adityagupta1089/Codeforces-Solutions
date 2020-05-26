#ifndef ONLINE_JUDGE

#define DEBUG 1
#include <cstring>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <string>
#include <unordered_map>
#include <unordered_set>

#else

#define DEBUG 0
#include <bits/stdc++.h>

#endif

using namespace std;

typedef int64_t ll;
typedef pair<int, int> pii;

int main() {
    ios::sync_with_stdio(false);
    if (DEBUG) freopen("../input.txt", "r", stdin);
    int n, m, k;
    cin >> n >> m >> k;
    pii r[n], c[m];
    for (int i = 0; i < n; i++) r[i] = {0, -1};
    for (int i = 0; i < m; i++) c[i] = {0, -1};
    for (int i = 0; i < k; i++) {
        int p, x, y;
        cin >> p >> x >> y;
        if (p == 1)
            r[x - 1] = {y, i};
        else if (p == 2)
            c[x - 1] = {y, i};
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            pii c1 = r[i], c2 = c[j];
            printf("%d ", c1.second > c2.second ? c1.first : c2.first);
        }
        printf("\n");
    }

    return 0;
}
