#include <bits/stdc++.h>

using namespace std;

#define mp make_pair
#define pb push_back

#define fst first
#define snd second

#define contains(x, y) ((x).find(y) != (x).end())

typedef pair<int, int> pii;

int main() {
	priority_queue<pii> pq;
	int n;
	cin >> n;
	vector<string> actions(n);
	for (int i = 0; i < n; i++) {
		int k;
		cin >> k;
		if (k == 0) {
			int cnt = 0;
			string action = "";
			while (cnt < 3 && !pq.empty()) {
				pii top = pq.top();
				pq.pop();
				if (cnt == 0) {
					actions[-top.snd] = "pushStack";
					action += " popStack";
				} else if (cnt == 1) {
					actions[-top.snd] = "pushFront";
					action += " popFront";
				} else if (cnt == 2) {
					actions[-top.snd] = "pushQueue";
					action += " popQueue";
				}
				cnt++;
			}
			stringstream ss;
			ss << cnt;
			string cnts = ss.str();
			actions[i] = cnts + action;
			pq = priority_queue<pii>();
		} else {
			pq.push(mp(k, -i));
			actions[i] = "pushBack";
		}
	}
	for (string action : actions) {
		cout << action << "\n";
	}
}
