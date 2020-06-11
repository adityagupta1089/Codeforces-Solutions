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
    int n;
    cin >> n;
    map<int, vector<pair<int, char>>> events;
    for (int i = 0; i < n; i++) {
        char g;
        int a, b;
        cin >> g >> a >> b;
        events[a].push_back({0, g});
        events[b + 1].push_back({1, g});
    }
    int mc = 0, fc = 0;
    int mv = 0;
    for (auto kv : events) {
        auto v = kv.second;
        for (auto dg : v) {
            int dx = dg.first == 0 ? 1 : -1;
            if (dg.second == 'M')
                mc += dx;
            else
                fc += dx;
        }
        // printf("k=%d, mc=%d, fc=%d\n", kv.first, mc, fc);
        mv = max(mv, 2 * min(mc, fc));
    }
    cout << mv << "\n";
    return 0;
}