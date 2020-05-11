#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    while (n--) {
        int v[3];
        scanf("%d %d %d", v, v + 1, v + 2);
        sort(v, v + 3);
        int tot = min(v[0], v[2] - v[1]);
        v[0] -= tot;
        v[2] -= tot;
        if (v[0] == 0) {//tot=v[0]
            tot += min(v[1], v[2]);
        } else {//tot=v[2]-v[1] => v[2]=v[1]
            int d = v[0] / 2;
            tot += v[0] + max(0, min(v[1] - d, v[1] - (v[0] - d)));
        }
        printf("%d\n", tot);
    }
}