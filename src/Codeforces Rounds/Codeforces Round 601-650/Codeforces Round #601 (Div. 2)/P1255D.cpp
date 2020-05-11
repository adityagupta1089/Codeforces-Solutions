#include <iostream>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int r, c, k;
        cin >> r >> c >> k;
        bool farm[r][c];
        int rc = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                char rice;
                cin >> rice;
                farm[i][j] = rice == 'R';
                if (farm[i][j])rc++;
            }
        }
        int arc = rc / k;
        int extra = rc % k;
        char sol[r][c];
        int curr = 0;
        char curr_c = '0';
        int cc = 0;
        for (int i = 0; i < c; i++) {
            bool even = i % 2 == 0;
            for (int j = even ? 0 : r - 1; even ? j < r : j >= 0; j += even ? 1 : -1) {
                sol[j][i] = curr_c;
                if (farm[j][i]) {
                    curr++;
                }
                if (cc < k - 1 && curr >= arc + (cc < extra ? 1 : 0)) {
                    cc++;
                    if (isalpha(curr_c + 1) || isdigit(curr_c + 1))
                        curr_c++;
                    else if (curr_c < 'A')curr_c = 'A';
                    else if (curr_c < 'a')curr_c = 'a';
                    curr = 0;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cout << sol[i][j];
            }
            cout << "\n";
        }
    }
}