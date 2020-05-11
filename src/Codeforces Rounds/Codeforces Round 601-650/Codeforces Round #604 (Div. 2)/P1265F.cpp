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

int n, * k;
int64_t** dp;

const int64_t M = 998244353;
string s;

int64_t modpow(int x) {
    if (x == 0) return 1;
    if (x == 1) return 2;
    if (x % 2 == 0) {
        int64_t val = modpow(x / 2);
        return (val * val) % M;
    } else {
        int64_t val = modpow(x / 2);
        return (((val * val) % M) * 2) % M;
    }
}

int64_t get_dp(int i, int j) {
    int pi = i, pj = j;
    if (i >= j) return 0;
    if (dp[i][j] != -1)
        return dp[i][j];
    int64_t ans = 0;
    int ki = k[j - 1] - k[i];
    if (s[j] != ')') {
        ans += get_dp(i, j - 1);
        ans %= M;
    }
    if (s[i] != '(') {
        ans += get_dp(i + 1, j);
        ans %= M;
    }
    if (s[i] != '(' && s[j] != ')') {
        ans -= get_dp(i + 1, j - 1);
        ans = (M + ans) % M;
    }
    if (s[i] != ')' && s[j] != '(') {
        // s[i] = '('
        ans += modpow(ki);
        ans %= M;

        ans += get_dp(i + 1, j - 1);
        ans %= M;
    }
    dp[pi][pj] = ans;
    //printf("dp[%d][%d] = %lld\n", pi, pj, dp[pi][pj]);
    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin >> s;
    n = s.length();
    dp = new int64_t* [n];
    for (int i = 0; i < n; i++) {
        dp[i] = new int64_t[n];
        for (int j = 0; j < n; j++) {
            dp[i][j] = -1;
        }
    }
    k = new int[n];
    for (int i = 0; i < n; i++) {
        k[i] = (i > 0 ? k[i - 1] : 0) + (s[i] == '?' ? 1 : 0);
    }
    cout << get_dp(0, n - 1);
    return 0;
}