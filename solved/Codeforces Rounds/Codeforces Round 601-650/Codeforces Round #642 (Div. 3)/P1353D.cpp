#include <iostream>
#include <queue>

using namespace std;

typedef uint64_t ll;

struct pair_comp {
    bool operator()(pair<int, int> p1, pair<int, int> p2) {
        int sz1 = p1.second - p1.first;
        int sz2 = p2.second - p2.first;
        if (sz1 == sz2) {
            return p1.first > p2.first;
        } else {
            return sz1 < sz2;
        }
    }
};

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int a[n];
        priority_queue<pair<int, int>, vector<pair<int, int>>, pair_comp>
            ranges;
        ranges.push({0, n - 1});
        // printf("pushed (%d, %d)\n", ranges.top().first, ranges.top().second);
        for (int i = 1; i <= n; i++) {
            pair<int, int> top = ranges.top();
            ranges.pop();
            int l = top.first, r = top.second;
            int m = (r - l + 1 % 2 != 0) ? (l + r) / 2 : (l + r - 1) / 2;
            // printf("top = (%d, %d) [m=%d]\n", l, r, m);
            if (l <= m - 1) {
                ranges.push({l, m - 1});
                // printf("pushed (%d, %d)\n", l, m - 1);
            }
            if (m + 1 <= r) {
                ranges.push({m + 1, r});
                // printf("pushed (%d, %d)\n", m + 1, r);
            }

            a[m] = i;
        }
        for (int x : a) {
            cout << x << " ";
        }
        cout << "\n";
    }
    return 0;
}