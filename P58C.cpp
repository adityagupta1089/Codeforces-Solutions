#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

int main() {
	int n;
	cin >> n;
	int a[n];
	for (int i = 0; i < n; i++)
		cin >> a[i];
	int d[n];
	map<int, int> cnt;
	for (int i=0;i<n;i++){
		int diff=a[i]-min(i+1,n-i);
		if (cnt.find(diff)==cnt.end()){
			cnt[diff]=0;
		}
		cnt[diff]++;
	}
	int mxcnt = 0;
	for (auto x : cnt) {
		if (x.first >= 0)
			mxcnt = max(mxcnt, x.second);
	}
	cout << (n - mxcnt) << "\n";
}
