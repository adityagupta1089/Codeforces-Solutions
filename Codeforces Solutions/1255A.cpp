#include <iostream>

int solve(int a, int b, int k = 5);

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int a, b;
        cin >> a >> b;
        cout << solve(a, b) << "\n";
    }
}


int solve(int a, int b, int k) {
    int delta = abs(b - a);
    if (k == 1) return delta;
    int min_val = INT_MAX;
    for (int i = 0; i < 2; i++) {
        int x = a, y = b;
        int ck = delta / k + i;
        x += (x > y ? -k : k) * ck;
        if (x >= 0) {
            min_val = min(min_val, ck + solve(x, y, k == 5 ? 2 : 1));
        }
    }
    return min_val;
}
