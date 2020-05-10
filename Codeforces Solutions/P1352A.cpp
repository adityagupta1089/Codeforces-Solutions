#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        int n = s.size();
        int k = 0;
        for (char c : s) {
            if (c != '0') {
                k++;
            }
        }
        cout << k << "\n";
        for (int i = 0; i < n; i++) {
            if (s[i] != '0') {
                cout << s[i];
                for (int j = i + 1; j < n; j++) {
                    cout << 0;
                }
                cout << " ";
            }
        }
        cout << "\n";
    }
    return 0;
}