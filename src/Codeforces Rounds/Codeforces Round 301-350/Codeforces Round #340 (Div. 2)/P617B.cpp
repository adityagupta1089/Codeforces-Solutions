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

int main() {
    ios::sync_with_stdio(false);
    if (DEBUG) freopen("../input.txt", "r", stdin);
    int n;
    cin >> n;
    vector<int> pos;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        if (x == 1) pos.push_back(i);
    }
    if (pos.size() == 0) {
        printf("0\n");
        return 0;
    }
    ll p = 1;
    for (int i = 0; i + 1 < pos.size(); i++) {
        p *= pos[i + 1] - pos[i];
    }
    printf("%lld\n", p);
    return 0;
}
