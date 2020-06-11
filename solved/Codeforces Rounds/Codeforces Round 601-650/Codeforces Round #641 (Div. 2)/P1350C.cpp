#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

typedef uint64_t ll;

ll pow(int x, int a) {
    if (a == 0) return 1;
    ll v = pow(x, a / 2);
    if (a % 2 == 0) {
        return v * v;
    } else {
        return v * v * x;
    }
}
int main() {
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    int a[n];
    unordered_map<int, vector<int>> divs;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        int x = a[i];
        for (int j = 2; j * j <= x && x > 1; j = (j == 2 ? 3 : j + 2)) {
            int c = 0;
            while (x % j == 0) {
                x /= j;
                c++;
            }
            divs[j].push_back(c);
        }
        if (x != 1) {
            divs[x].push_back(1);
        }
    }
    ll ans = 1;
    for (auto div : divs) {
        int p = div.first;
        auto cs = div.second;
        int zc = n - cs.size();
        if (zc < 2) {
            sort(cs.begin(), cs.end());
            ans *= pow(p, cs[1 - zc]);
        }
    }
    cout << ans << "\n";
    return 0;
}