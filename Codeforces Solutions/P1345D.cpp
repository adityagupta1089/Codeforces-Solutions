#include <cstring>
#include <iostream>
#include <queue>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;
struct pair_hash {
    size_t operator()(const pair<int, int>& p) const {
        return 1000 * p.first + p.second;
    }
};
unordered_map<pair<int, int>, pair<int, int>, pair_hash> parent;

pair<int, int> root(pair<int, int> x) {
    while (parent[x] != x) {
        auto next = parent[x];
        parent[x] = parent[next];
        x = next;
    }
    return x;
}

int main() {
    ios::sync_with_stdio(false);
    int n, m;
    cin >> n >> m;
    bool black[n][m];
    queue<pair<int, int>> blacks;
    int row[n];
    int col[m];
    memset(row, 0, sizeof(int) * n);
    memset(col, 0, sizeof(int) * m);
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < m; j++) {
            black[i][j] = s[j] == '#';
            if (black[i][j]) {
                pair<int, int> cell = make_pair(i, j);
                row[i]++;
                col[j]++;
                blacks.push(cell);
                parent[cell] = cell;
            }
        }
    }
    bool rowx[n];
    bool colx[m];
    memset(rowx, false, sizeof(bool) * n);
    memset(colx, false, sizeof(bool) * m);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (row[i] == 0 && col[j] == 0) {
                rowx[i] = true;
                colx[j] = true;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        // check_row
        bool start = false, end = false;
        int count = 0;
        for (int j = 0; j < m; j++) {
            if (black[i][j]) count++;
            if (black[i][j] && !start) start = true;
            if (!black[i][j] && start) end = true;
            if (end && black[i][j]) {
                cout << "-1\n";
                return 0;
            }
        }
        if (count == 0 && !rowx[i]) {
            cout << "-1\n";
            return 0;
        }
    }
    for (int j = 0; j < m; j++) {
        // check col
        bool start = false, end = false;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (black[i][j]) count++;
            if (black[i][j] && !start) start = true;
            if (!black[i][j] && start) end = true;
            if (end && black[i][j]) {
                cout << "-1\n";
                return 0;
            }
        }
        if (count == 0 && !colx[j]) {
            cout << "-1\n";
            return 0;
        }
    }
    while (!blacks.empty()) {
        auto top = blacks.front();
        blacks.pop();
        int x = top.first, y = top.second;
        vector<pair<int, int>> dxys = {{0, 1}, {1, 0}};
        for (pair<int, int> dxy : dxys) {
            int dx = dxy.first, dy = dxy.second;
            if (0 <= x + dx && x + dx < n && 0 <= y + dy && y + dy < m &&
                black[x + dx][y + dy]) {
                parent[root(top)] = root(make_pair(x + dx, y + dy));
            }
        }
    }
    unordered_set<pair<int, int>, pair_hash> roots;
    for (auto const& loc_parent : parent) {
        roots.insert(root(loc_parent.first));
    }
    cout << roots.size() << "\n";
    return 0;
}