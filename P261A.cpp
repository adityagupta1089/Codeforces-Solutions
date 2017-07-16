#include <bits/stdc++.h>

using namespace std;

#define mp make_pair
#define pb push_back

#define fst first
#define snd second

#define contains(x, y) ((x).find(y) != (x).end())

typedef pair<int, int> pii;

int main() {
	int m;
	cin >> m;
	int q[m];
	for (int i = 0; i < m; i++)
		cin >> q[i];
	sort(q, q + m);
	int n;
	cin >> n;
	int a[n];
	for (int i = 0; i < n; i++)
		cin >> a[i];
	sort(a, a + n);
	int i = n - 1;
	int b = n;
	int my = 0;
	do {
		int f = b < q[0] ? 0 : min(2, b - q[0]);
		for (int k = 0; k < q[0] && i >= 0; k++, i--) {
			my += a[i];
			b--;
		}
		i -= f;
		b -= f;
	} while (b != 0);
	cout << my << "\n";
}
