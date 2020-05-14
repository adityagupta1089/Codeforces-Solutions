#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    int N = 1e6;
    int div[N + 1];
    for (int i = 2; i <= N; i++) {
        div[i] = i;
    }
    for (int i = 2; i * i <= N; i++) {
        for (int k = i * i; k <= N; k += i) {
            if (div[k] == k) div[k] = i;
        }
    }
    while (t--) {
        int n, k;
        cin >> n >> k;
        if (n % 2 == 0) {
            n += 2 * k;
        } else {
            n += div[n];
            n += 2 * (k - 1);
        }
        cout << n << "\n";
    }
    return 0;
}