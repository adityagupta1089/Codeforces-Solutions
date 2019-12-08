#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        unordered_set<int> set;
        int ans[n];
        vector<pair<int, int>> later;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int k;
            cin >> k;
            if (set.find(k) == set.end()) {
                set.insert(k);
                ans[i] = k;
            } else {
                later.emplace_back(k, i);
            }
        }
        for (pair<int, int> ki: later) {
            int k = ki.first;
            int i = ki.second;
            cnt++;
            k -= k % 10;
            for (int j = 0; j < 10; j++) {
                if (set.find(k + j) == set.end()) {
                    set.insert(k + j);
                    ans[i] = k + j;
                    break;
                }
            }
        }


        printf("%d\n", cnt);
        for (int x:ans) {
            printf("%04d\n", x);
        }

    }

}