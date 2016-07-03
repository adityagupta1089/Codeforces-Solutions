#include <iostream>
#include <cstdlib>
#define f(i,m) for(int i=0;i<m;i++)

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int n;
	cin >> n;
	int a[n];
	int max = 0, min = 101;
	f(i,n)
	{
		cin >> a[i];
		if (a[i] < min)
			min = a[i];
		if (a[i] > max)
			max = a[i];
	}
	int minp = -1, maxp = -1;
	f(i,n)
	{
		if (maxp == -1 && a[i] == max)
			maxp = i;
		if (minp == -1 && a[n - 1 - i] == min)
			minp = i;
	}
	//cout<<minp<<" "<<maxp<<" ";
	if (maxp <= n-1-minp)
		cout << minp + maxp;
	else
		cout << minp + maxp - 1;
}
