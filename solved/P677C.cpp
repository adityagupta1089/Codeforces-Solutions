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

#define M 1000000007

/*
    digits from '0' to '9' correspond to integers from 0 to 9;
    letters from 'A' to 'Z' correspond to integers from 10 to 35;
    letters from 'a' to 'z' correspond to integers from 36 to 61;
    letter '-' correspond to integer 62;
    letter '_' correspond to integer 63.
*/
int ord(char c) {
    if ('0' <= c && c <= '9')
        return c - '0';
    else if ('A' <= c && c <= 'Z')
        return c - 'A' + 10;
    else if ('a' <= c && c <= 'z')
        return c - 'a' + 36;
    else if (c == '-')
        return 62;
    else if (c == '_')
        return 63;
    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    if (DEBUG) freopen("../input.txt", "r", stdin);
    int cnt[64];
    memset(cnt, 0, sizeof(cnt));
    for (int i = 0; i < 64; i++) {
        for (int j = 0; j < 64; j++) {
            cnt[i & j]++;
        }
    }
    string s;
    cin >> s;
    vector<int> a;
    ll sol = 1;
    for (char c : s) {
        sol *= cnt[ord(c)];
        sol %= M;
    }
    printf("%lld\n", sol);
    return 0;
}
