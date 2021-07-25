#ifdef ONLINE_JUDGE
#include <bits/stdc++.h>
#else

#define DEBUG 1

#include <iostream>

#endif

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        bool valid = true;
        unsigned long n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s[i];
            if (c == '?') {
                for (char d: "abc") {
                    if ((i == 0 || s[i - 1] != d) && (i == n - 1 || s[i + 1] != d)) {
                        s[i] = d;
                        break;
                    }
                }
                if (s[i] == '?') {
                    valid = false;
                    break;
                }
            } else if ((i > 0 && s[i - 1] == s[i]) || (i + 1 < n && s[i + 1] == s[i])) {
                valid = false;
                break;
            }
        }
        if (valid) {
            cout << s << "\n";
        } else {
            cout << "-1\n";
        }
    }
    return 0;
}