#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int p[n];
    long dp[n];
    long dp2[n];
    for (int i = 0; i < n; i++) {
        cin >> p[i];
        p[i]--;
    }
    dp[0] = 0;
    dp2[0] = 0;
    for (int i = 0; i < n; i++) {
        dp[i] = 0;
        dp2[i] = 0;
        if (p[i] == i) {
            dp[i] = 2;
        } else {
            int start = (p[i] > 0) ? dp2[p[i] - 1] : 0;
            int end = dp2[i - 1];
            dp[i] = (end - start) + 2;
            while (dp[i] < 0) dp[i] += 1000000007;
            dp[i] %= 1000000007;
        }
        dp2[i] += dp[i];
        dp2[i] %= 1000000007;
        if (i > 0) {
            dp2[i] += dp2[i - 1];
            dp2[i] %= 1000000007;
        }
    }
    // for (int i = 0; i < n; i++) {
    //     printf("i = %d, dp = %d, dp2 = %d, p = %d\n", i, dp[i], dp2[i],
    //     p[i]);
    // }
    cout << (dp2[n - 1] % 1000000007) << "\n";
    return 0;
}