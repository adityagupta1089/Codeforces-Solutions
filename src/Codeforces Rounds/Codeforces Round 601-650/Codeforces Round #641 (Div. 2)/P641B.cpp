#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int s[n + 1], dp[n + 1];
        for (int i = 1; i <= n; i++) {
            cin >> s[i];
            dp[i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                if (s[j] > s[i]) dp[j] = max(dp[j], dp[i] + 1);
            }
        }
        int mx = 0;
        for (int i = 1; i <= n; i++) {
            mx = max(mx, dp[i]);
        }
        cout << mx << "\n";
    }
    return 0;
}