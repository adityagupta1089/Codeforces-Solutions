#ifndef ONLINE_JUDGE

#include <cstring>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>

#else

#include <bits/stdc++.h>

#endif

using namespace std;

typedef int64_t ll;
typedef pair<int, int> pii;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        int k = n / 2, l = m / 2;
        int ans = INT_MAX;
        if (n % 2 != 0 && m % 2 != 0) ans = min(ans, 2 * k * l + k + l + 1);
        ans = min(ans, min(n * ((m + 1) / 2), m * ((n + 1) / 2)));
        printf("%d\n", ans);
    }
    return 0;
}