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
    int a[n];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        a[i]--;
    }
    int totcnt[n];
    memset(totcnt, 0, sizeof(totcnt));
    for (int i = 0; i < n; i++) {
        int cntcolor[n], cnt[n], mv = 0;
        memset(cnt, 0, sizeof(cnt));
        fill(cntcolor, cntcolor + n, n);
        cntcolor[0] = 0;
        for (int j = i; j < n; j++) {
            cnt[a[j]]++;
            mv = max(mv, cnt[a[j]]);
            cntcolor[cnt[a[j]]] = min(cntcolor[cnt[a[j]]], a[j]);
            totcnt[cntcolor[mv]]++;
        }
    }
    for (int x : totcnt) {
        printf("%d ", x);
    }
    printf("\n");
    return 0;
}
