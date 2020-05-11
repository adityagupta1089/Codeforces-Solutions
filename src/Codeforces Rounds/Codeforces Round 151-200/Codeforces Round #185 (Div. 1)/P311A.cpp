#include <bits/stdc++.h>

using namespace std;

#define mp make_pair
#define pb push_back

#define fst first
#define snd second

#define contains(x, y) ((x).find(y) != (x).end())

typedef pair<int, int> pii;

int main() {
	int n, k;
	cin >> n >> k;
	//n-1+n-2+...1 = n(n-1)/2
	if (n * (n - 1) / 2 <= k) {
		cout << "no solution\n";
	} else {
		for (int i = 0; i < n; i++) {
			cout << "0 " << i << "\n";
		}
	}
}
