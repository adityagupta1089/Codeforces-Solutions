#include <math.h>

#include <iostream>

using namespace std;
typedef uint64_t ll;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        ll n;
        cin >> n;
        int cnt = 0;
        while (n >= 2) {
            int c = floor((sqrt(1 + 24 * n) - 1) / 6);
            n -= c * (3 * c + 1) / 2;
            cnt++;
        }
        cout << cnt << "\n";
    }
    return 0;
}