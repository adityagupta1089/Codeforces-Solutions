#include <bits/stdc++.h>

using namespace std;

#define mp make_pair
#define pb push_back

#define fst first
#define snd second

#define contains(x, y) ((x).find(y) != (x).end())

typedef pair<int, int> pii;

int main() {
	string s;
	cin >> s;
	set<char> s1689;
	vector<int> rest;
	int zc = 0;
	int v[] =
		{ 8169, 6189, 1689, 6891, 8691, 9861, 1896 };
	for (char c : s) {
		if ((c == '1' || c == '6' || c == '8' || c == '9')
				&& !contains(s1689, c)) {
			s1689.insert(c);
		} else if (c != '0') {
			rest.pb(c - '0');
		} else {
			zc++;
		}
	}
	int q = 0;
	for (int x : rest) {
		q *= 10;
		q += x;
		q %= 7;
		cout << x;
	}
	q *= 4;
	q %= 7;
	cout << v[(7 - q) % 7];
	for (int i = 0; i < zc; i++)
		cout << 0;
	cout << "\n";

}
