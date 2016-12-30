#include <iostream>

#define f(i,m) for(int i=0;i<m;i++)
#define min(a,b) (a<b?a:b)
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int n;
	cin >> n;
	int h[n], a[n];
	f(i,n)
	{
		cin >> h[i] >> a[i];
	}
	int c = 0;
	f(i,n)
	{
		f(j,n)
		{
			if (j != i && h[i] == a[j]) {
				c++;
			}
		}
	}
	cout << c;
}
