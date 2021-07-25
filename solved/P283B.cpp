#include <cstring>
#include <iostream>
#include <unordered_map>
#include <unordered_set>

using namespace std;
typedef int64_t ll;

struct pair_hash {
    size_t operator()(const pair<int, bool>& p) const {
        return p.first + (p.second ? 200000 : 0);
    }
};

unordered_set<pair<int, bool>, pair_hash> visited;
unordered_map<pair<int, bool>, ll, pair_hash> cache;
int* a;
int n;

ll solve(int i, bool inc) {
    pair<int, bool> key = {i, inc};
    if (visited.count(key) > 0) {
        cache[key] = -1;
    } else {
        visited.insert(key);
        int next = inc ? i + a[i] : i - a[i];
        if (next == 1) {
            cache[key] = -1;
        } else if (next <= 0 || next > n) {
            cache[key] = a[i];
        } else {
            pair<int, bool> key2 = {next, !inc};
            ll v = (cache.count(key2) > 0) ? cache[key2] : solve(next, !inc);
            cache[key] = (v == -1) ? -1 : a[i] + v;
        }
    }
    return cache[key];
}

int main() {
    ios::sync_with_stdio(false);
    cin >> n;
    a = new int[n + 1];
    for (int i = 2; i <= n; i++) cin >> a[i];
    for (int i = 2; i <= n; i++) {
        pair<int, bool> key = {i, false};
        ll v = (cache.count({key}) > 0) ? cache[key] : solve(i, false);
        cout << (v == -1 ? -1 : v + i - 1) << "\n";
    }
    return 0;
}