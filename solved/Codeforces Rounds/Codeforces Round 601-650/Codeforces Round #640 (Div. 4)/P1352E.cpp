#include <cstring>
#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = 1, v = a[0];
            while (l <= r && (v != a[i] || r - l < 2) && r <= n) {
                if (r < n && v <= a[i]) {
                    v += a[r];
                    r++;
                } else {
                    v -= a[l];
                    l++;
                }
            }
            if (v == a[i] && r - l >= 2) {
                count++;
            }
        }
        cout << count << "\n";
    }
    return 0;
}