#include <algorithm>
#include <iostream>
#include <iterator>
#include <utility>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	int n;
	cin >> n;
	vector<pair<int, int> > vec;
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		vec.push_back(make_pair(a, i + 1));
	}
	std::sort(vec.begin(), vec.end());
	vector<pair<int, int> > l, r;
	for (int i = vec.size() - 1, j = 0; i >= 0; i--, j++) {
		if (j % 2 == 0)
			l.push_back(vec[i]);
		else
			r.push_back(vec[i]);
	}
	cout << l.size() << "\n";
	for (auto it = l.begin(); it != l.end(); it++)
		cout << it->second << " ";
	cout << "\n";
	cout << r.size() << "\n";
	for (auto it = r.begin(); it != r.end(); it++)
		cout << it->second << " ";
	cout << "\n";
	return 0;
}
