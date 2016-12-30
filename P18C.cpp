#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	int n;
	cin >> n;
	int a[n], sm[n];
	for (int i = 0; i < n; i++) {
		cin >> a[i];
		sm[i] = a[i] + (i > 0 ? sm[i - 1] : 0);
	}
	int cnt = 0;
	for (int i = 0; i < n - 1; i++) {
		if (sm[i] == sm[n - 1] - sm[i]) {
			cnt++;
		}
	}
	cout << cnt << "\n";
	return 0;
}
