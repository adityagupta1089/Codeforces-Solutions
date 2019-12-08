#ifdef ONLINE_JUDGE
#include <bits/stdc++.h>
#else

#define DEBUG 1

#include <iostream>
#include <unordered_set>

#endif

using namespace std;

int root(int parent[], int x) {
    while (parent[x] != x) {
        parent[x] = parent[parent[x]];
        x = parent[x];
    }
    return x;
}

void join(int parent[], int size[], int a, int b) {
    int root_a = root(parent, a);
    int root_b = root(parent, b);
    if (size[root_a] > size[root_b]) {
        parent[root_b] = root_a;
        size[root_a] += size[root_b];
    } else {
        parent[root_a] = root_b;
        size[root_b] += size[root_a];
    }
}

int main() {
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    int parent[26];
    int size[26];
    bool present[26];
    memset(present, false, 26);
    for (int i = 0; i < 26; i++) {
        parent[i] = i;
        size[i] = 1;
    }
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        for (char c:s) {
            present[c - 'a'] = true;
            join(parent, size, c - 'a', s[0] - 'a');
        }
    }
    unordered_set<int> roots;
    for (int i = 0; i < 26; i++) {
        if (present[i])roots.insert(root(parent, i));
    }
    printf("%d\n", (int) roots.size());

    return 0;
}