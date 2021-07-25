#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    /*
        4 3 2
        2 3 5
        4 1 2

        1 -> [2,4]
        2 -> [3,4,5]
        3 -> [2,4,5]
        4 -> [1,2,3]
        5 -> [2,3]

        1 -> [2->[3,4,5],4->[2,3]]
     */
    unordered_map<int, unordered_set<int>> mp;
    unordered_map<int, unordered_set<int>> mp2;
    for (int i = 0; i < n - 2; i++) {
        int q1, q2, q3;
        cin >> q1 >> q2 >> q3;
        mp[q1].insert(q2);
        mp[q1].insert(q3);
        mp[q2].insert(q1);
        mp[q2].insert(q3);
        mp[q3].insert(q1);
        mp[q3].insert(q2);

        mp2[q1].insert(q2);
        mp2[q1].insert(q3);
        mp2[q2].insert(q1);
        mp2[q2].insert(q3);
        mp2[q3].insert(q1);
        mp2[q3].insert(q2);
    }
    int sol[n];
    int p1 = 0, p2 = n - 1;
    int curr = 0, curr2 = 0;
    for (int i = 1; i <= n; ++i) {
        if (mp[i].size() == 2) {
            if (curr == 0)curr = i;
            else if (curr2 == 0)curr2 = i;
            else break;
        }
    }
    // a b c d => (a,b,c) (b,c,d), (c,d,e)
    unordered_set<int> remaining;
    for (int i = 1; i <= n; i++) {
        remaining.insert(i);
    }
    while (p1 < p2) {
        remaining.erase(curr);
        remaining.erase(curr2);
        sol[p1++] = curr;
        sol[p2--] = curr2;
        int next_curr = 0, next_curr2 = 0;
        for (int x:mp[curr]) {
            mp[x].erase(curr);
            if (mp[x].size() == 2 && next_curr == 0) {
                next_curr = x;
            }
        }
        for (int x:mp2[curr2]) {
            mp2[x].erase(curr2);
            if (mp2[x].size() == 2 && next_curr2 == 0) {
                next_curr2 = x;
            }
        }
        curr = next_curr;
        curr2 = next_curr2;
    }
    if (!remaining.empty() && n % 2 == 1) {
        sol[p1++] = *remaining.begin();
    }
    for (int x:sol) {
        cout << x << " ";
    }
    cout << "\n";
}