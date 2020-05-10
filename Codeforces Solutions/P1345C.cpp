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
        int degree[n];
        memset(degree, 0, sizeof(int) * n);
        for (int i = 0; i < n; i++) {
            cin >> a[i];
            a[i] %= n;
            while (a[i] <= 0) a[i] += n;
            a[i] %= n;
            degree[i]--;
            degree[(i + a[i]) % n]++;
        }
        bool valid = true;
        for (int x : degree) {
            if (x != 0) {
                valid = false;
                break;
            }
        }
        cout << (valid ? "YES" : "NO") << "\n";
    }
    return 0;
}