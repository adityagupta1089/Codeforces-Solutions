#ifndef ONLINE_JUDGE

#define DEBUG 1
#include <cstring>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <string>
#include <unordered_map>
#include <unordered_set>

#else

#define DEBUG 0
#include <bits/stdc++.h>

#endif

using namespace std;

typedef int64_t ll;
typedef pair<int, int> pii;

unordered_map<char, pii> pos{
    {'1', {0, 0}}, {'2', {0, 1}}, {'3', {0, 2}}, {'4', {1, 0}}, {'5', {1, 1}},
    {'6', {1, 2}}, {'7', {2, 0}}, {'8', {2, 1}}, {'9', {2, 2}}, {'0', {3, 1}},
};

bool valid(pii p) {
    for (auto& cp : pos) {
        if (p == cp.second) return true;
    }
    return false;
}

int main() {
    ios::sync_with_stdio(false);
    if (DEBUG) freopen("../input.txt", "r", stdin);
    int n;
    cin >> n;
    char a[n];
    vector<pii> poss;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        poss.push_back(pos[a[i]]);
    }
    vector<pii> deltas;
    for (int i = 0; i + 1 < n; i++) {
        pii delta = {poss[i + 1].first - poss[i].first,
                     poss[i + 1].second - poss[i].second};
        if (DEBUG) printf("delta = (%d, %d)\n", delta.first, delta.second);
        deltas.push_back(delta);
    }
    int cnt = 0;
    for (auto& cp : pos) {
        // printf("c=%c\n", cp.first);
        bool is_valid = true;
        pii start = cp.second;
        // printf("> (%d, %d)", start.first, start.second);
        for (pii delta : deltas) {
            pii next = {start.first + delta.first, start.second + delta.second};
            // printf(" -> (%d, %d)", next.first, next.second);
            if (!valid(next)) {
                is_valid = false;
                break;
            } else {
                start = next;
            }
        }
        // printf("\n");
        if (is_valid) cnt++;
        if (DEBUG) printf("c=%c, valid=%d\n", cp.first, is_valid);
        if (cnt > 1) break;
    }
    printf(cnt == 1 ? "YES\n" : "NO\n");
    return 0;
}
