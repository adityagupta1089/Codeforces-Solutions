#include <iostream>
#include <math.h>

using namespace std;

typedef uint64_t ll;

int main() {
    ios::sync_with_stdio(false);
    ll t;
    cin >> t;
    while(t--){
        ll n, m;
        cin >>n >> m;
        if (n==1){
            cout << "0\n";
        }else if (n==2){
            cout << m << "\n";
        }else {
            cout << 2*m << "\n";
        }        
    }
    return 0;
}