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
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a + n);
    ll sum = 0;
    for (int i = 1; i < n; i++) {
        sum += a[i] - a[0];
    }
    ll md = sum;
    int m = a[0];
    // printf("%d -> %d\n", m, md);
    for (int i = 1; i < n; i++) {
        ll n1 = max(0, i - 1), n2 = max(n - i - 1, 0);
        // printf("i=%d, n1=%d, n2=%d\n", i, n1, n2);
        sum += (n1 - n2) * (a[i] - a[i - 1]);
        if (DEBUG) printf("%d -> %lld [md=%lld, m=%d]\n", a[i], sum, md, m);
        if (sum < md) {
            md = sum;
            m = a[i];
        }
    }
    printf("%d\n", m);
    return 0;
}
