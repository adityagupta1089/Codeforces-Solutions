#include <cstring>
#include <iostream>

using namespace std;

typedef uint64_t ll;

int solve(int n, int k, string s) {
    int cnt[k];
    int total_ones = 0;
    memset(cnt, 0, sizeof(int) * k);
    int start = -1, end = -1;
    for (int i = 0; i < n; i++) {
        if (s[i] == '1') {
            total_ones++;
            if (start == -1) start = i;
            end = i;
            cnt[i % k]++;
        }
    }
    if (start >= 0) {
        int mn = 2 * n;
        for (int i = 0; i < k; i++) {
            int v = total_ones - cnt[i];
            int istart = start + (k + i - start) % k;
            int iend = end - (k + end - i) % k;
            int positions = max(0, (iend - istart) / k + 1);
            int dp[positions];
            memset(dp, 0, sizeof(dp));
            int ones_count = 0, ans = 2 * n;
            for (int j = 0; j < positions; j++) {
                int p = istart + j * k;
                int o = s[p] == '1' ? 1 : 0;
                dp[j] = min(j > 1 ? dp[j - 1] : 0, ones_count) + (1 - o);
                ones_count += o;
                ans = min(ans, dp[j] + cnt[i] - ones_count);
            }
            ans = min(ans, ones_count);
            mn = min(mn, v + ans);
        }
        return mn;
    } else {
        return 0;
    }
}

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        string s;
        cin >> s;
        cout << solve(n, k, s) << "\n";
    }
    return 0;
}