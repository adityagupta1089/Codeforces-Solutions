#include <iostream>

using namespace std;

int gcd(int a, int b) {
    if (b > a) return gcd(b, a);
    if (b == 0) return a;
    return gcd(b, a % b);
}

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    for (int i = 0; i < t; i++) {
        int a, b;
        cin >> a >> b;
        cout << (gcd(a, b) == 1 ? "Finite" : "Infinite") << "\n";
    }
    return 0;
}