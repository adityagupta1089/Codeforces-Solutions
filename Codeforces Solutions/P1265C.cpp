#ifdef ONLINE_JUDGE
#include <bits/stdc++.h>
#else

#define DEBUG 1

#include <iostream>
#include <vector>

#endif

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    // 0<g<s,b
    // n[g]>n[s]>n[b]>n[?]
    // g+s+b <= n/2 => 3g<n/2 => g<n/6
    // g=1, s>=2, b<=n/2-3
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int ps[n];
        vector<pair<int, int>> pcs;
        for (int i = 0; i < n; i++) {
            cin >> ps[i];
        }
        int p = 0, i = 0, c = 0;
        while (i < n) {
            while (i < n && ps[i] == ps[p]) {
                i++;
                c++;
            }
            if (i < n && ps[i] != ps[p]) {
                pcs.emplace_back(ps[p], c);
                p = i;
                c = 0;
            }
        }
        pcs.emplace_back(ps[p], c);
        int m = pcs.size();
        int g = pcs[0].second;
        c = 0;
        i = 1;
        while (i < m && c <= g) {
            c += pcs[i].second;
            i++;
        }
        int s = c;
        c = 0;
        while (i < m && (c <= g || g + s + c + pcs[i].second <= n / 2)) {
            c += pcs[i].second;
            i++;
        }
        int b = c;
        if (s > g && b > g && g + s + b <= n / 2) {
            printf("%d %d %d\n", g, s, b);
        } else {
            printf("0 0 0\n");
        }
    }
    return 0;
}