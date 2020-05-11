#include <iostream>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        int a[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            cin >> a[i];
            sum += a[i];
        }
        if (m < n || n <= 2) {
            cout << "-1\n";
        } else {
            cout << 2 * sum << "\n";
            for (int i = 0; i < n; ++i) {
                printf("%d %d\n", i + 1, (i + 1) % n + 1);
            }
        }
    }
}

