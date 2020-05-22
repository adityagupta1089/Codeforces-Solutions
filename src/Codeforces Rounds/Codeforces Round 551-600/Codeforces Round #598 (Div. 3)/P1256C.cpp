#ifdef LOCAL
#define DEBUG 1
#else
#define DEBUG 0
#endif
#define debug(x)                                     \
    {                                                \
        if (DEBUG) cout << #x << " = " << x << "\n"; \
    }
#include <cstring>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <string>
#include <unordered_map>
#include <unordered_set>

using namespace std;

typedef uint64_t ll;

struct val {
    bool poss;
    int n;
    int m;
};

struct pair_hash {
    size_t operator()(const pair<int, int>& p) const {
        return p.first * 1000 + p.second;
    }
};
int M, N, D;
int* c;

unordered_map<pair<int, int>, val, pair_hash> cache;

val get_sol(int m, int n) {
    if (cache.count({m, n}) == 0) {
        val ans{false, -1, -1};
        if (m == M) {
            ans = {n < D, -1, m + 1};
        } else {
            for (int i = 0; i < D; i++) {
                int m2 = m + 1, n2 = n - c[m] - i;
                val _ans = get_sol(m2, n2);
                if (_ans.poss) {
                    ans = {true, n2, m2};
                    break;
                }
            }
        }
        cache[{m, n}] = ans;
    }
    return cache[{m, n}];
}

int main() {
    ios::sync_with_stdio(false);
    if (DEBUG) freopen("../input.txt", "r", stdin);
    cin >> N >> M >> D;
    if (DEBUG) printf("n=%d, m=%d, d=%d\n", N, M, D);
    c = new int[M];
    for (int i = 0; i < M; i++) {
        cin >> c[i];
    }
    val ans = get_sol(0, N);
    if (ans.poss) {
        int cnt = 0;
        printf("YES\n");
        int arr[N];
        memset(arr, 0, sizeof(arr));
        while (ans.m <= M) {
            if (DEBUG) printf("{%d,m=%d, n=%d}\n", ans.poss, ans.m, ans.n);
            for (int i = 0; i < c[ans.m - 1]; i++) {
                arr[N - ans.n - i - 1] = ans.m;
            }
            ans = cache[{ans.m, ans.n}];
        }
        for (int x : arr) printf("%d ", x);
        printf("\n");
    } else {
        printf("NO\n");
    }
    return 0;
}