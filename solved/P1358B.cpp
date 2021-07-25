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
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        sort(a, a + n);
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            if (a[i - 1] <= i) {
                cnt = max(cnt, i + 1);
            }
        }
        printf("%d\n", cnt);
    }
    return 0;
}