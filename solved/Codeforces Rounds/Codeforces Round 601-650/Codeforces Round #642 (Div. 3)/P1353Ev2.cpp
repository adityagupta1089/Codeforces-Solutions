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
        int minimum_moves = 2 * n;
        for (int i = 0; i < k; i++) {
            int out_of_position_ones = total_ones - cnt[i];
            int istart = start + (k + i - start) % k;
            int iend = end - (k + end - i) % k;
            int positions = max(0, (iend - istart) / k + 1);
            int dp[3][positions];
            memset(dp, 0, sizeof(dp));
            for (int j = 0; j < positions; j++) {
                int p = istart + j * k;
                int is_one = s[p] == '1' ? 1 : 0;
                dp[0][j] = (j > 0 ? dp[0][j - 1] : 0) + (is_one ? 1 : 0);
                dp[1][j] =
                    min(j > 0 ? dp[0][j - 1] : 0, j > 0 ? dp[1][j - 1] : 0) +
                    (is_one ? 0 : 1);
                dp[2][j] =
                    min(j > 0 ? dp[1][j - 1] : 0, j > 0 ? dp[2][j - 1] : 0) +
                    (is_one ? 1 : 0);
            }
            int in_position_fix_moves =
                min(dp[0][positions - 1],
                    min(dp[1][positions - 1], dp[2][positions - 1]));
            minimum_moves = min(minimum_moves,
                                out_of_position_ones + in_position_fix_moves);
        }
        return minimum_moves;
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