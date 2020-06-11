#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        int a, b, c;
        cin >> a >> b >> c;
        if (a > 0)
            for (int i = 0; i <= a; i++) cout << 0;
        if (c > 0) {
            // b must be >0
            if (a > 0) b--;
            for (int i = 0; i <= c; i++) cout << 1;
            for (int i = 0; i < b; i++) cout << (i % 2 == 0 ? 0 : 1);
        } else {
            if (a == 0) cout << 0;
            for (int i = 0; i < b; i++) cout << (i % 2 == 0 ? 1 : 0);
        }
        cout << "\n";
    }
    return 0;
}