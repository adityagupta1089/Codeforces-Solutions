#include <iostream>

using namespace std;

typedef uint64_t ll;

int main() {
    ios::sync_with_stdio(false);
    ll a, b, c, d;
    cin >> a >> b >> c >> d;
    ll cnt = 0;
    for (ll x = a; x <= b; x++) {
        ll y0 = max(b, c - x + 1);
        ll y1 = c;
        ll z0 = max(y0 - x + 1, c);
        ll z1 = min(x + y0 - 1, d);
        ll z2 = max(y1 - x + 1, c);
        ll z3 = min(x + y1 - 1, d);
        // printf("x=%lld, y0=%lld, y1=%lld, z0=%lld, z1=%lld, z2=%lld,
        // z3=%lld\n",
        //        x, y0, y1, z0, z1, z2, z3);
        ll w0 = z1 - z0 + 1;
        ll w1 = z3 - z2 + 1;
        ll wm = min(max(w0, w1), min(2 * x - 1, d - c + 1));
        // printf("w0=%lld, w1=%lld, wm=%lld\n", w0, w1, wm);
        // stage 1 from y=y0 to d-x+1
        ll y11 = y0, y12 = min(y1, d - x + 1);
        if (y11 <= y12) {
            ll v = wm * (wm + 1) / 2 - w0 * (w0 - 1) / 2;
            // printf("stage 1 (%lld -> %lld) = %lld \n", y11, y12, v);
            cnt += v;
        }
        // stage 3 from y=d-x+2 to y=y1
        ll y21 = max(y0, y12 + 1), y22 = y1;
        if (y21 <= y22) {
            ll v = wm * (y22 - y21 + 1);
            // printf("stage 3 (%lld -> %lld) = %lld \n", y21, y22, v);
            cnt += v;
        }
    }
    cout << cnt << "\n";
    return 0;
}