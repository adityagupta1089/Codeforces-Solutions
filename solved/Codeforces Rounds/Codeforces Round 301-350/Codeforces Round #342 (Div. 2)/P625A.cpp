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

ll fb(ll x, ll a, ll b, ll c) {
    ll ans = 0;
    while (x >= b) {
        ll gb = x / b;
        ans += gb;
        x %= b;
        x += gb * c;
    }
    ll ga = x / a;
    ans += ga;
    x %= a;
    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    if (DEBUG) freopen("../input.txt", "r", stdin);
    ll n, a, b, c, beff;
    cin >> n >> a >> b >> c;
    beff = b - c;
    ll ca = n / a, cb = max(n - b, (ll)0) / beff;
    n -= cb * beff;
    if (n >= b) {
        n -= beff;
        cb++;
    }
    cb += n / a;
    printf("%lld\n", max(ca, cb));
    return 0;
}
