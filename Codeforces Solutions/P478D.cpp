#include <math.h>

#include <cstring>
#include <iostream>
#include <map>
#include <numeric>

using namespace std;

int64_t M = 1e9 + 7;

int main() {
    int r, g;
    cin >> r >> g;
    int h = floor((sqrt(1 + 8 * (r + g)) - 1) / 2), n = h * (h + 1) / 2;
    int64_t *sol = new int64_t[1], *sol2;
    sol[0] = 1;
    for (int hh = 1; hh <= h; hh++) {
        int nn = hh * (hh + 1) / 2;
        sol2 = new int64_t[nn + 1];
        memset(sol2, 0, sizeof(int64_t) * (nn + 1));
        copy(sol, sol + nn - hh + 1, sol2);
        for (int rr = max(hh, nn - g); rr <= min(nn, r); rr++) {
            sol2[rr] += sol[rr - hh];
            sol2[rr] %= M;
        }
        int64_t* temp = sol;
        sol = sol2;
        delete[] temp;
    }
    cout << accumulate(sol + max(0, n - g), sol + min(n, r) + 1, 0,
                       [](int64_t a, int64_t b) { return (a + b) % M; })
         << "\n";
    return 0;
}