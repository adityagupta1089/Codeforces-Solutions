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
    int n, m;
    cin >> n >> m;
    unordered_map<int, set<pair<int, string>, greater<pair<int, string>>>>
        regions;
    for (int i = 0; i < n; i++) {
        string name;
        int region, score;
        cin >> name >> region >> score;
        regions[region].insert({score, name});
    }
    for (int i = 1; i <= m; i++) {
        auto it = regions[i].begin();
        auto first = *it;
        it++;
        auto second = *it;
        it++;
        if (it != regions[i].end()) {
            auto third = *it;
            if (third.first == second.first) {
                printf("?\n");
                continue;
            }
        }
        printf("%s %s\n", first.second.c_str(), second.second.c_str());
    }
    return 0;
}
