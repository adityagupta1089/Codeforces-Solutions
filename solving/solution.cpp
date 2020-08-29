#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

long M = 1e9 + 7;
int debug = 1;

string longestDupSubstring(string s) {
    int n = s.length();
    if (debug) {
        for (int i = 0; i < n; i++) {
            printf("%d -> %c\n", i, s[i]);
        }
    }
    int lo = 1, hi = n - 1;
    pair<int, int> ans = {0, -1};
    while (lo <= hi) {
        unordered_map<long, vector<pair<int, int>>> map;
        int mid = (lo + hi) / 2;
        if (debug) printf("lo = %d, hi = %d, mid = %d\n", lo, hi, mid);
        long res = 0;
        long prefix = 1;
        for (int i = 0; i < mid; i++) {
            res += prefix * (s[i] - 'a');
            res %= M;
            if (i != mid - 1) {
                prefix *= 26;
                prefix %= M;
            }
        }
        map[res].push_back({0, mid - 1});
        if (debug) printf("[%d] %s -> %ld\n", 0, s.substr(0, mid).c_str(), res);
        bool found = false;
        for (int i = mid; i < n; i++) {
            res =
                (res - (s[i - mid] - 'a')) * 576923081 + (s[i] - 'a') * prefix;
            res %= M;
            if (debug)
                printf("[%d] %s -> %ld\n", i - mid + 1,
                       s.substr(i - mid + 1, mid).c_str(), res);
            if (map.count(res) > 0) {
                if (debug) printf("found a substring with hash %ld\n", res);
                for (auto p : map[res]) {
                    if (debug)
                        printf("matching (%d, %d) with (%d, %d)\n", p.first,
                               p.second, i - mid + 1, i);
                    bool matched = true;
                    for (int j = p.first, k = i - mid + 1; j < p.second;
                         j++, k++) {
                        if (s[j] != s[k]) {
                            matched = false;
                            break;
                        }
                    }
                    if (matched) {
                        ans = p;
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                if (debug) printf("found (%d, %d)\n", ans.first, ans.second);
                break;
            }
            map[res].push_back({i - mid + 1, i});
        }
        if (found) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    if (debug) printf("ans = (%d, %d)\n", ans.first, ans.second);
    return s.substr(ans.first, ans.second - ans.first + 1);
}

int main() {
    string s = "aaaaa";
    string t = longestDupSubstring(s);
    printf("%s [%lu]\n%s [%lu]\n", s.c_str(), s.length(), t.c_str(),
           t.length());
}