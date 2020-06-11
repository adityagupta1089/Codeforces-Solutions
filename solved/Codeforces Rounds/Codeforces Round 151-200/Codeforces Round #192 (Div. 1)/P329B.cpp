#include <iostream>
#include <queue>
#include <unordered_map>

using namespace std;

typedef uint64_t ll;

struct pair_hash {
    size_t operator()(const pair<int, int>& p) const {
        return p.first * 1000 + p.second;
    }
};

int main() {
    ios::sync_with_stdio(false);
    int r, c;
    cin >> r >> c;
    char mat[r][c];
    pair<int, int> exit;
    for (int i = 0; i < r; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < c; j++) {
            mat[i][j] = s[j];
            if (mat[i][j] == 'E') {
                exit = {i, j};
            }
        }
    }
    //printf("exit = (%d, %d)\n", exit.first, exit.second);
    queue<pair<pair<int, int>, int>> bfs;
    bfs.push({exit, 0});
    unordered_map<pair<int, int>, bool, pair_hash> visited;
    unordered_map<int, int> dis_cnts;
    int start_dis = 0;
    while (!bfs.empty()) {
        auto top = bfs.front();
        bfs.pop();
        if (visited[top.first]) continue;
        visited[top.first] = true;
        int x = top.first.first;
        int y = top.first.second;
        int d = top.second;
        if (mat[x][y] == 'S') {
            start_dis = d;
        } else if (mat[x][y] > '0' && mat[x][y] <= '9') {
             //printf("[%c] x=%d, y=%d, d=%d\n", mat[x][y], x, y, d);
            if (dis_cnts.count(d) == 0) {
                dis_cnts[d] = 0;
            }
            dis_cnts[d] += mat[x][y] - '0';
        }
        vector<pair<int, int>> dxys = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (pair<int, int> dxy : dxys) {
            int nx = x + dxy.first;
            int ny = y + dxy.second;
            if (0 <= nx && nx < r && 0 <= ny && ny < c && mat[nx][ny] != 'T' &&
                !visited[{nx, ny}]) {
                bfs.push({{nx, ny}, d + 1});
            }
        }
    }
    int sm = 0;
    for (const auto& p : dis_cnts) {
        if (p.first <= start_dis) {
            sm += p.second;
        }
         //printf("%d = %d\n", p.first, p.second);
    }
    cout << sm << "\n";
    return 0;
}