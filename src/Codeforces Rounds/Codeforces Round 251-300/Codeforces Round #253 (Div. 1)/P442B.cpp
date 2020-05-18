#include <algorithm>
#include <iostream>
using namespace std;

typedef uint64_t ll;

int main() {
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    double p[n];
    for (int i = 0; i < n; i++) cin >> p[i];
    sort(p, p + n);
    double a = 0, b = 1, Q;
    for (int i = n - 1; i >= 0; i--) {
        if (p[i] == 1) {
            Q = 1;
            break;
        }
        a += p[i] / (1 - p[i]);
        b *= 1 - p[i];
        Q = a * b;
        if (a > 1) break;
    }
    cout.precision(9);
    cout << Q << "\n";
}