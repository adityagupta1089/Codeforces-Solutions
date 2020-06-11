#ifdef ONLINE_JUDGE

#define DEBUG 0
#include <bits/stdc++.h>

#else

#define DEBUG 1

#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>

#endif

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    int sx, sy;
    cin >> sx >> sy;
    pair<int, int> points_x[n];
    pair<int, int> points_y[n];
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        points_x[i] = make_pair(x, y);
        points_y[i] = make_pair(y, x);
    }
    sort(points_x, points_x + n);
    sort(points_y, points_y + n);
    int cnt_x_b = 0, cnt_x_a = 0;
    int cnt_y_b = 0, cnt_y_a = 0;
    int lxb = 1, fxa = -1;
    int lyb = 1, fya = -1;
    for (auto p: points_x) {
        if (p.first < sx) {
            cnt_x_b++;
            lxb = p.first;
        }
        if (p.first > sx) {
            cnt_x_a++;
            fxa = fxa != -1 ? fxa : p.first;
        }
    }
    for (auto p: points_y) {
        if (p.first < sy) {
            cnt_y_b++;
            lyb = p.first;
        }
        if (p.first > sy) {
            cnt_y_a++;
            fya = fya != -1 ? fya : p.first;
        }
    }
    int mx = max(cnt_x_b, cnt_x_a);
    int my = max(cnt_y_a, cnt_y_b);
    cout << max(mx, my) << "\n";
    int cx, cy;
    if (mx > my) {
        cx = cnt_x_a >= cnt_x_b ? fxa : lxb;
        cy = sy;
    } else {
        cx = sx;
        cy = cnt_y_a >= cnt_y_b ? fya : lyb;
    }
    cout << cx << " " << cy << "\n";
    return 0;
}