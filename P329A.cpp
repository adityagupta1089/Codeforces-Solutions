#include <bits/stdc++.h>

using namespace std;

#define mp make_pair
#define pb push_back

#define fst first
#define snd second

#define contains(x, y) ((x).find(y) != (x).end())

typedef pair<int, int> pii;

int main() {
	int n;
	cin >> n;
	char grid[n][n];
	for (int i = 0; i < n; i++) {
		cin >> grid[i];
	}
	map<int, vector<pii>> rmp;
	map<int, vector<pii>> cmp;
	bool rn = false;
	bool cn = false;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (grid[i][j] == '.') {
				rmp[i].pb(mp(i, j));
			}
			if (grid[j][i] == '.') {
				cmp[i].pb(mp(j, i));
			}
		}
		if (rmp[i].size() == 0) rn = true;
		if (cmp[i].size() == 0) cn = true;
	}
	if (rn && cn) {
		printf("-1\n");
		return 0;
	}
	if (!rn) {
		for (int i = 0; i < n; i++) {
			printf("%d %d\n", 1 + rmp[i][0].fst, 1 + rmp[i][0].snd);
		}
		return 0;
	}
	//if (!cn) {
	for (int i = 0; i < n; i++) {
		printf("%d %d\n", 1 + cmp[i][0].fst, 1 + cmp[i][0].snd);
	}
	//}
	return 0;

}
