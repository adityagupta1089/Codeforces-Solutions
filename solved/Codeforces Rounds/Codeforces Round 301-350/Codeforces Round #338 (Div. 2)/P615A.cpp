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
    int n, m;
    cin >> n >> m;
    bool on[m];
    memset(on, false, sizeof(on));
    for (int i = 0; i < n; i++) {
        int ni;
        cin >> ni;
        for (int j = 0; j < ni; j++) {
            int x;
            cin >> x;
            on[x - 1] = true;
        }
    }
    bool valid = true;
    for (int i = 0; i < m; i++) {
        if (!on[i]) {
            valid = false;
            break;
        }
    }
    printf(valid ? "YES\n" : "NO\n");
    return 0;
}
