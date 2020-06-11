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

template <class TH>
void _dbg(const char* sdbg, TH h) {
    cerr << sdbg << "=" << h << "\n";
}

template <class TH, class... TA>
void _dbg(const char* sdbg, TH h, TA... a) {
    while (*sdbg != ',') {
        cerr << *sdbg++;
    }
    cerr << "=" << h << ",";
    _dbg(sdbg + 1, a...);
}

#ifndef ONLINE_JUDGE
#define DEBUG 1
#define debug(...) _dbg(#__VA_ARGS__, __VA_ARGS__)
#else
#define DEBUG 0
#define debug(...) (__VA_ARGS__)
#endif

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    if (!DEBUG) {
        freopen("b.in", "r", stdin);
        freopen("b.out", "w", stdout);
    }
    int n, m;
    cin >> n >> m;
    debug(n, m);
    int i = 0, q = 0, r = n;
    debug(q, r);
    unordered_map<int, int> mp;
    while (true) {
        q = r / m;
        r = r % m;
        debug(q, r);
        if (mp.count(r) == 0) {
            mp[r] = i;
        } else {
            int pi = mp[r];
            cout << pi << " " << (r == 0 ? 0 : i - pi) << "\n";
            return 0;
        }
        r *= 10;
        i++;
    }
    return 0;
}