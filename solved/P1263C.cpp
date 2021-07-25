#ifdef ONLINE_JUDGE
#include <bits/stdc++.h>

#else

#define DEBUG 1

#include <iostream>
#include <vector>
#include <cmath>

#endif


using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int k = 1;
        vector<int> ans;
        while (k <= n) {
            int x = n / k;
            ans.push_back(n / k);
            k = floor((double) n / (double) x) + 1;
        }
        ans.push_back(0);
        printf("%d\n", ans.size());
        reverse(ans.begin(), ans.end());
        for (int x:ans) {
            printf("%d ", x);
        }
        printf("\n");
    }
}