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

struct pair_hash {
    size_t operator()(const pair<int, int>& p) const {
        return p.first * 1000 + p.second;
    }
};

int main() {
    ios::sync_with_stdio(false);
    if (DEBUG) freopen("../input.txt", "r", stdin);
    int n;
    cin >> n;
    int a[n];
    vector<pair<int, int>> ans;
    int curr = 0, start = 0, end = 0;
    bool valid = false;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        if (a[i] == 0 || curr + a[i] != 0) {
            curr += a[i];
        } else {
            ans.push_back({start, i - 1});
            start = i;
            curr = a[i];
        }
        valid = valid || a[i] != 0;
    }
    if (start < n) ans.push_back({start, n - 1});
    if (valid) {
        printf("YES\n%lu\n", ans.size());
        for (auto& p : ans) {
            printf("%d %d\n", p.first + 1, p.second + 1);
        }
    } else {
        printf("NO\n");
    }
    return 0;
}
