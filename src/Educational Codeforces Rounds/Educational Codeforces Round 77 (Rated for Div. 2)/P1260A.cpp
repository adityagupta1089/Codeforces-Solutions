#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int c, sum;
        cin >> c >> sum;
        // c=4 sum=6 extra=2 rest=2
        long extra = sum % c;
        long rest = c - extra;
        long res = (sum / c) * (sum / c) * rest + (sum / c + 1) * (sum / c + 1) * extra;
        cout << res << "\n";
    }

}