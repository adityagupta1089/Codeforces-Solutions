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

#define M 998244353

using namespace std;

int64_t inv(int a, int m) {
    int m0 = m;
    int y = 0, x = 1;

    if (m == 1)
        return 0;

    while (a > 1) {
        // q is quotient
        int q = a / m;
        int t = m;

        // m is remainder now, process same as
        // Euclid's algo
        m = a % m, a = t;
        t = y;

        // Update y and x
        y = x - q * y;
        x = t;
    }

    // Make x positive
    if (x < 0)
        x += m0;

    return x;
}

int64_t gcd(int64_t a, int64_t b) {
    if (a < b)return gcd(b, a);
    if (b == 0)return a;
    return gcd(b, a % b);
}

int main() {
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    int p[n];
    for (int i = 0; i < n; i++) {
        cin >> p[i];
    }
    int64_t num = 0;
    int64_t alpha = 1;
    int64_t den = 1;
    for (int i = 0; i < n; i++) {
        int64_t pi = (p[i] * inv(100, M)) % M;
        num += alpha;
        num %= M;

        alpha *= pi;
        alpha %= M;

        den *= pi;
        den %= M;
    }
    int64_t ans = (num * inv(den, M)) % M;
    printf("%ld\n", ans);
    return 0;
}