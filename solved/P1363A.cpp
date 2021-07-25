#include <algorithm>
#include <cstring>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>

using namespace std;

typedef int64_t ll;
typedef pair<int, int> pii;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        int n, x;
        cin >> n >> x;
        int a[n];
        int ec = 0, oc = 0;
        for (int i = 0; i < n; i++) {
            cin >> a[i];
            if (a[i] % 2 == 0)
                ec++;
            else if (a[i] % 2 != 0)
                oc++;
        }
        bool valid = false;
        for (int i = 1; i <= x; i += 2) {
            if (oc >= i && ec >= (x - i)) {
                valid = true;
                break;
            }
        }
        cout << (valid ? "Yes" : "No") << "\n";
    }
    return 0;
}