#include <iostream>
#include <numeric>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int64_t r, b, k;
        cin >> r >> b >> k;
        /*
         * red: 0, r, 2r, 3r, ...
         * blue: 0, b, 2b, 3b, ...
         * consecutive same color
         * WLOG red
         * xb < ar < (a+1)r < (a+2)r <  .. (a+k-1)r < (x+1)b
         * (k-1)r < b
         * (r-1) r ... (k-1)r k*r-1
         * r=5,b=2,k=3
         * 5 > 2*2
         *  5x < 2a < 2a+2 < 2a+4 < 5x+5
         *  1 1-11 11
         *  2 1-11 11
         *  ...
         *  90 1-11 11 | 990
         *  {1 91 10} -> 1000
         *  min |ar-xb|
         */
        int64_t g = gcd(r, b);
        if (b >= (k - 1) * r + 2 * g || r >= (k - 1) * b + 2 * g) {
            cout << "REBEL\n";
        } else {
            cout << "OBEY\n";
        }
    }
}