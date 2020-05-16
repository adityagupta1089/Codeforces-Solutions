#include <iostream>
#include <algorithm>
using namespace std;

typedef uint64_t ll;

int main() {
    ios::sync_with_stdio(false);
    int t;cin>>t;
    while(t--){
        int n, k;
        cin>>n>>k;
        int a[n], b[n];
        for(int i=0;i<n;i++)
            cin>>a[i];
        for(int i=0;i<n;i++)
            cin>>b[i];    
        sort(a, a+n);
        sort(b, b+n);
        int l=0, r=n-1;
        int sum = 0;
        for(int i=0;i<k;i++){
            if (a[l]<b[r]){
                int temp = a[l];
                a[l] = b[r];
                b[r] = temp;
                l++;r--;
            }else {
                break;
            }
        }
        for(int x:a)sum += x;
        cout << sum << "\n";
    }
    return 0;
}