#include <bits/stdc++.h>

using namespace std;

int main() {
	int n;
	scanf("%d", &n);
	int mood[n];
	int l = 0, maxl = 0;
	int s = -1;
	bool allgood = true;
	for (int i = 0; i < n; i++) {
		cin >> mood[i];
		if (!mood[i]) {
			allgood = false;
			l++;
		} else {
			if (l > maxl) {
				maxl = l;
			}
			s = i;
			l = 0;
		}
	}
	if (allgood) {
		printf("YES\n");
		return 0;
	}
	if (s != -1) {
		for (int i = 0; i < s; i++) {
			if (!mood[i]) {
				l++;
			} else {
				if (l > maxl) {
					maxl = l;
				}
				s = i;
				l = 0;
			}
		}
	}
	vector<int> diffs;
	for (int i = max(1, maxl + 1); i * 3 <= n; i++)
		if (n % i == 0) {
			diffs.push_back(i);
		}
	for (vector<int>::iterator it = diffs.begin(); it != diffs.end(); it++) {
		int diff = *it;
		for (int ss = 0; ss < diff; ss++) {
			if (!mood[ss]) continue;
			bool yes = true;
			int cnt = 1;
			int p = ss;
			do {
				if (!mood[p]) {
					yes = false;
					break;
				} else cnt++;
				p = (p + diff + n) % n;
			} while (p != ss);
			if (cnt > 2 && yes) {
				printf("YES\n");
				return 0;
			}
		}
	}
	printf("NO\n");
	return 0;
}
