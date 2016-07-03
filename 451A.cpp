#include <iostream>
#include <cstdlib>
#define f(i,m) for(int i=0;i<m;i++)
#define min(a,b) (a<b?a:b)
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int m,n;
	cin >> m>>n;
	cout<<((min(m,n)%2==1)?"Akshat":"Malvika");
}
