#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

int main() {
	int x0, y0, x1, y1;
	scanf("%d %d %d %d", &x0, &y0, &x1, &y1);
	int n;
	scanf("%d", &n);
	map<int, vector<pair<int, int> > > rws;
	for (int i = 0; i < n; i++) {
		int ri, ai, bi;
		scanf("%d %d %d", &ri, &ai, &bi);
		rws[ri].push_back(make_pair(ai, bi));
	}
	for (int i = 0; i < n; i++) {
		sort(rws[i].begin(), rws[i].end());
	}
	queue<pair<pair<int, int>, int> > q;
	set<pair<int, int> > vstd;
	q.push(make_pair(make_pair(x0, y0), 0));
	while (!q.empty()) {
		pair<pair<int, int>, int> top1 = q.front();
		pair<int, int> top = top1.first;
		q.pop();
		if (vstd.find(top) != vstd.end()) continue;
		vstd.insert(top);
		for (int dy = -1; dy <= 1; dy++) {
			int r = top.first + dy;
			if (rws.find(r) == rws.end()) continue;
			for (int dx = -1; dx <= 1; dx++) {
				if (dx != 0 || dy != 0) {
					int c = top.second + dx;
					if (vstd.find(make_pair(r, c)) != vstd.end()) continue;
					if (r == x1 && c == y1) {
						printf("%d\n", 1 + top1.second);
						return 0;
					}
					for (vector<pair<int, int> >::iterator it = rws[r].begin();
							it != rws[r].end(); it++) {
						if (it->first <= c && c <= it->second) {
							q.push(make_pair(make_pair(r, c), 1 + top1.second));
							break;
						}
					}
				}
			}
		}
	}
	printf("-1\n");
	return 0;
}
