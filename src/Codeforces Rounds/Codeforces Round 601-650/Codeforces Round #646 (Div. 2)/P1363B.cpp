#include <algorithm>
#include <cstring>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>

using namespace std;

typedef int64_t ll;
typedef pair<int, int> pii;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        int n = s.length();
        int oc[n];
        memset(oc, 0, sizeof(oc));
        oc[0] = s[0] == '1' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            oc[i] = oc[i - 1] + (s[i] == '1' ? 1 : 0);
        }
        int ans = n + 1;
        for (int i = 0; i <= n; i++) {
            int loc = (i > 0 ? oc[i - 1] : 0), roc = oc[n - 1] - loc,
                lzc = (i > 0 ? i - loc : 0), rzc = n - loc - roc - lzc;
            // printf("s=%s, loc=%d, roc=%d, lzc=%d, rzc=%d\n", s.c_str(), loc,
            //        roc, lzc, rzc);
            ans = min(ans, min(loc + rzc, lzc + roc));
        }
        cout << ans << "\n";
    }
    return 0;
}