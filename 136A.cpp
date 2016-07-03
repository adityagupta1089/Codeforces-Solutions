#include <iostream>
using namespace std;

int main() {
	int n;
	cin>>n;
	int a[n];
	for(int i=0;i<n;i++){
		int m;
		cin>>m;
		a[m-1]=i+1;
	}
	for(int i=0;i<n;i++){
		cout<<a[i]<<" ";
	}
}
