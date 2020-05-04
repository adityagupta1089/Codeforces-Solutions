#ifdef ONLINE_JUDGE

#define DEBUG 0
#include <bits/stdc++.h>

#else

#define DEBUG 1

#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>

#endif

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int a, b, c, d, e, f;
    cin >> a >> b >> c >> d >> e >> f;
    int t2_max = min(b, min(c, d)), t1_max = min(a, d);
    int t1, t2;
    if (f >= e) {
        t2 = t2_max;
        t1 = min(t1_max, d - t2);
    } else {
        t1 = t1_max;
        t2 = min(t2_max, d - t1);
    }
    cout << e * t1 + f * t2;
    return 0;
}