#include <algorithm>
#include <cstring>
#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int n, m;
    cin >> n >> m;
    bool mat[n][m];
    int col_vals[m][m + 1];
    memset(col_vals, 0, sizeof(int) * m * (m + 1));
    for (int i = 0; i < n; i++) {
        string c;
        cin >> c;
        int cs = 0;
        for (int j = 0; j < m; j++) {
            mat[i][j] = c[j] == '1';
            cs = mat[i][j] ? cs + 1 : 0;
            col_vals[j][cs]++;
        }
    }
    int mx = 0;
    for (int i = 0; i < m; i++) {
        int cv = 0;
        for (int j = m; j > 0; j--) {
            cv += col_vals[i][j];
            mx = max(mx, j * cv);
        }
    }
    cout << mx << "\n";
    return 0;
}