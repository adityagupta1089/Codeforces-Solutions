#include <iostream>
#include <map>

using namespace std;

typedef uint64_t ll;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int e[n];
        map<int, int> cnts;
        for (int i = 0; i < n; i++) {
            cin >> e[i];
            if (cnts.count(e[i]) == 0) cnts[e[i]] = 0;
            cnts[e[i]]++;
        }
        int gs = 0;
        for (auto it = cnts.begin(); it != cnts.end(); it++) {
            int e = it->first;
            int c = it->second;
            gs += c / e;
            // printf("%d -> %d\n", e, c);
            if (next(it) != cnts.end()) {
                next(it)->second += c % e;
            }
        }
        cout << gs << "\n";
    }
    return 0;
}