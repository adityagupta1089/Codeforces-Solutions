#include <iostream>

using namespace std;

typedef uint64_t ll;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        ll a, k;
        cin >> a >> k;
        for (int i = 0; i < k - 1; i++) {
            int minv = 10, maxv = -1;
            ll b = a;
            while (b > 0) {
                int v = b % 10;
                minv = min(minv, v);
                maxv = max(maxv, v);
                b /= 10;
            }
            a += minv * maxv;
            if (minv == 0) break;
        }
        cout << a << "\n";
    }
    return 0;
}