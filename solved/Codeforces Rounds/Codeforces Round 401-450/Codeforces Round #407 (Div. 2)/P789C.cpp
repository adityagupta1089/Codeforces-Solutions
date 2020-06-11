#ifdef LOCAL
#define DEBUG 1
#else
#define DEBUG 0
#endif
#define debug(x)                                     \
    {                                                \
        if (DEBUG) cout << #x << " = " << x << "\n"; \
    }
#include <cstring>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <string>
#include <unordered_map>
#include <unordered_set>

using namespace std;

typedef int64_t ll;

int main() {
    ios::sync_with_stdio(false);
    if (DEBUG) freopen("../input.txt", "r", stdin);
    int n;
    cin >> n;
    ll a[n], b[n], c[n], m = 1e9 + 1, M = -(1e9 + 1);
    memset(c, 0, sizeof(c));
    ll ans = 0;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        if (i > 0) {
            b[i] = a[i] > a[i - 1] ? a[i] - a[i - 1] : a[i - 1] - a[i];
            if (i > 0) {
                c[i] = c[i - 1] + (i % 2 == 0 ? -1 : 1) * b[i];
            }
            ans = max(ans, (i % 2 == 0) ? M - c[i] : c[i] - m);
        }
        m = min(m, c[i]);
        M = max(M, c[i]);
    }
    cout << ans << "\n";
    return 0;
}