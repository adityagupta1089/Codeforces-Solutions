#include <cstdio>
#include <iostream>
#include <string>
#include <utility>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	int n, m, x, y;
	cin >> n >> m >> x >> y;
	int img[n][m];
	for (int i = 0; i < n; i++) {
		string line;
		cin >> line;
		for (int j = 0; j < m; j++) {
			img[i][j] = line[j] == '#' ? 1 : 0;
		}
	}
	int cng[m][2];
	int sm[m + 1][2];
	sm[0][0] = 0;
	sm[0][1] = 0;
	for (int i = 0; i < m; i++) {
		cng[i][0] = 0;
		cng[i][1] = 0;
		sm[i + 1][0] = 0;
		sm[i + 1][1] = 0;
		for (int j = 0; j < n; j++) {
			if (img[j][i] != 1)
				cng[i][1]++;
			if (img[j][i] != 0)
				cng[i][0]++;
		}
		sm[i + 1][0] += (i > 0 ? sm[i][0] : 0) + cng[i][0];
		sm[i + 1][1] += (i > 0 ? sm[i][1] : 0) + cng[i][1];
	}
	int dp[m + 1][2];
	dp[0][0] = 0;
	dp[0][1] = 0;
	//0:4 5 4 2 2
	//1:2 1 2 4 4
	for (int i = 1; i <= m; i++) {
		dp[i][0] = 1 << 30;
		dp[i][1] = 1 << 30;
		for (int j = i - x; j >= i - y && j >= 0; j--) {
			dp[i][0] = min(dp[i][0], dp[j][1] + sm[i][0] - sm[j][0]);
			dp[i][1] = min(dp[i][1], dp[j][0] + sm[i][1] - sm[j][1]);
		}
	}
	cout << min(dp[m][0], dp[m][1]);
	return 0;
}
