#include <iostream>

using namespace std;

int main() {
  int n1, n2, k1, k2;
  cin >> n1 >> n2 >> k1 >> k2;
  int dp[n1 + n2 + 1][n1 + 1][n2 + 1][2];
  for (int j = 0; j <= n1; j++) {
    for (int k = 0; k <= n2; k++) {
      dp[0][j][k][0] = 1;
      dp[0][j][k][1] = 1;
    }
  }
  for (int i = 1; i <= n1 + n2; i++) {
    for (int j = 0; j <= n1; j++) {
      for (int k = 0; k <= n2; k++) {
        dp[i][j][k][0] = 0;
        dp[i][j][k][1] = 0;
        for (int l = 1; l <= k1 && l <= j && l <= i; l++) {
          dp[i][j][k][0] += dp[i - l][j - l][k][1];
          dp[i][j][k][0] %= 100000000;
        }
        for (int m = 1; m <= k2 && m <= k && m <= i; m++) {
          dp[i][j][k][1] += dp[i - m][j][k - m][0];
          dp[i][j][k][1] %= 100000000;
        }
      }
    }
  }
  cout << (dp[n1 + n2][n1][n2][0] + dp[n1 + n2][n1][n2][1]) % 100000000 << "\n";
}
