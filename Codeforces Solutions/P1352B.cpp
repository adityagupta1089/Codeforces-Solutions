#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int t, n, k;
    cin >> t;
    while (t--) {
        cin >> n >> k;
        bool solved = false;
        for (int v = 1; v <= 2; v++) {
            int v2 = n - (k - 1) * v;
            if (v2 <= 0 || v2 % 2 != v % 2) {
                continue;
            } else {
                solved = true;
                cout << "YES\n";
                for (int i = 0; i < k - 1; i++) {
                    cout << v << " ";
                }
                cout << v2 << "\n";
                break;
            }
        }
        if (!solved) {
            cout << "NO\n";
        }
    }
    return 0;
}