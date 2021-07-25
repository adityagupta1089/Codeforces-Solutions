#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int t, n, k;
    cin >> t;
    while (t--) {
        cin >> n >> k;
        cout << (k / (n - 1)) * n + k % (n - 1) - (k % (n - 1) == 0 ? 1 : 0)
             << "\n";
    }
    return 0;
}