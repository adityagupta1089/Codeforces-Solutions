#ifdef ONLINE_JUDGE

#define DEBUG 0
#include <bits/stdc++.h>

#else

#define DEBUG 1


#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>

#endif


bool check_valid(int n, const bool* arr) {
    bool valid = true;
    for (int i = 0; i + 1 < n; i++) {
        if (arr[i] != arr[i + 1]) {
            valid = false;
            break;
        }
    }
    return valid;
}

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    string s;
    cin >> s;
    bool arr[n];
    for (int i = 0; i < n; i++) {
        arr[i] = s[i] == 'B';
    }
    vector<int> solution;
    for (int i = 0; i < n; i++) {
        if (arr[i]) {
            if (i + 1 < n) {
                solution.push_back(i);
                arr[i] = false;
                arr[i + 1] = !arr[i + 1];
            }
        }
    }
    if (!check_valid(n, arr)) {
        for (int i = 0; i < n; i++) {
            if (!arr[i] && i + 1 < n && !arr[i + 1]) {
                solution.push_back(i);
                arr[i] = true;
                arr[i + 1] = true;
            }
        }
    }
    if (!check_valid(n, arr)) {
        for (int i = 0; i < n; i++) {
            if (arr[i] && i + 1 < n && arr[i + 1]) {
                solution.push_back(i);
                arr[i] = false;
                arr[i + 1] = false;
            }
        }
    }
    bool valid = check_valid(n, arr);
    if (DEBUG) {
        for (bool b: arr) {
            cout << (b ? 'B' : 'W');
        }
        cout << "\n";
    }
    if (valid) {
        cout << solution.size() << "\n";
        for (int x:solution) {
            printf("%d ", x + 1);
        }
        printf("\n");
    } else {
        printf("-1\n");
    }
    return 0;
}

