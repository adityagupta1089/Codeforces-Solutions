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
#define debug(...) _dbg(#__VA_ARGS__, __VA_ARGS__)
#else
#define debug(...) (__VA_ARGS__)
#define cerr \
    if (0) cout
#endif

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    return 0;
}