#include <iostream>

using namespace std;

typedef uint64_t ll;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin>>t;
    while(t--){
        ll n;
        cin >> n;
        ll ans = 0;
        cout << n*(n-1)*(n+1)/3 << "\n";
    }
    return 0;
}