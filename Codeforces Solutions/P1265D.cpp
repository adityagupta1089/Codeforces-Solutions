#ifdef ONLINE_JUDGE

#define DEBUG 1
#include <bits/stdc++.h>

#else

#define DEBUG 1


#include <iostream>
#include <vector>
#include <algorithm>

#endif

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    int c[4];
    int d[4];
    scanf("%d %d %d %d", c, c + 1, c + 2, c + 3);
    bool found = false;
    for (int x1 = 0; x1 < 4; x1++) {
        for (int x2 = 0; x2 < 4; x2++) {
            if (x2 == x1)continue;
            for (int x3 = 0; x3 < 4; x3++) {
                vector<int> ans;
                if (x3 == x2 || x3 == x1)continue;
                int x4 = 6 - x1 - x2 - x3;
                vector<int> choices = {x1, x2, x3, x4};
                copy(c, c + 4, d);
                while (d[0] + d[1] + d[2] + d[3] > 0) {
                    found = false;
                    for (int i :choices) {
                        if (d[i] > 0 && (ans.empty() || abs(i - ans[ans.size() - 1]) == 1)) {
                            found = true;
                            ans.push_back(i);
                            d[i]--;
                            break;
                        }
                    }
                    if (!found) { break; }
                }
                if (found) {
                    printf("YES\n");
                    for (int x:ans) {
                        printf("%d ", x);
                    }
                    printf("\n");
                    return 0;
                }
            }
        }
    }
    printf("NO\n");
    return 0;
}


