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
    char s;
    int pc = 0, nc = 0, n = 0;
    bool positive = true;
    bool end = false;
    vector<char> ss;
    while (n == 0) {
        cin >> s;
        if (s == '?')
            positive ? pc++ : nc++;
        else if (s == '-')
            positive = false;
        else if (s == '+')
            positive = true;
        else if (s == '=') {
            cin >> n;
        }
        ss.push_back(s);
    }
    int vn, vp, vp2;
    bool sol = false;
    if (DEBUG) printf("pc=%d, nc=%d, n=%d\n", pc, nc, n);
    if (nc > 0) {
        for (vn = (pc - n) / nc; vn <= n * (pc - 1) / nc; vn++) {
            vp = (n + nc * vn) / pc;
            vp2 = vp + ((n + nc * vn) % pc == 0 ? 0 : 1);
            if (1 <= vn && vn <= n && 1 <= vp && vp2 <= n) {
                sol = true;
                break;
            }
        }
        if (!sol) {
            printf("Impossible\n");
            return 0;
        }
    } else {
        vp = n / pc;
        vp2 = vp + (n % pc == 0 ? 0 : 1);
    }
    if (vp <= 0 || vp2 > n) {
        printf("Impossible\n");
        if (DEBUG) printf("vp = %d\n", vp);
        return 0;
    } else {
        printf("Possible\n");
    }
    positive = true;
    int ppc = 0;
    for (char s : ss) {
        if (s == '+' || s == '-' || s == '=') {
            printf("%c ", s);
            if (s == '+')
                positive = true;
            else if (s == '-')
                positive = false;
        } else if (s == '?') {
            if (!positive) {
                printf("%d ", vn);
            } else if (ppc < (n + vn * nc) % pc) {
                printf("%d ", vp2);
                ppc++;
            } else if (positive) {
                printf("%d ", vp);
            }
        }
    }
    printf("%d\n", n);
    // printf("pc=%d, nc=%d, n=%d\n", pc, nc, n);
    return 0;
}
