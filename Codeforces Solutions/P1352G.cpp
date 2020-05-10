#include <cstring>
#include <iostream>
#include <stack>

using namespace std;

bool* visited;
int n;
stack<int> solution;
int visited_count = 0;

bool dfs(int curr) {
    // printf("curr = %d (visited_count = %d)\n", curr, visited_count);
    visited[curr] = true;
    visited_count++;
    if (visited_count == n + 1) {
        return true;
    }
    if (curr == 0) {
        for (int i = 1; i <= n; i++) {
            if (dfs(i)) {
                solution.push(i);
                return true;
            }
        }
    } else {
        for (int dx : {-4, -3, -2, 2, 3, 4}) {
            int next = curr + dx;
            if (1 <= next && next <= n && !visited[next]) {
                // cout << " next = " << next << " (curr=" << curr << ",dx=" <<
                // dx
                //  << ")\n";
                if (dfs(next)) {
                    solution.push(next);
                    return true;
                }
            }
        }
    }
    visited[curr] = false;
    visited_count--;
    return false;
}

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        cin >> n;
        visited = new bool[n + 1];
        memset(visited, false, (n + 1) * sizeof(bool));
        visited_count = 0;
        // cout << "n = " << n
        //  << " ====================================================\n";
        if (dfs(0)) {
            while (!solution.empty()) {
                cout << solution.top() << " ";
                solution.pop();
            }
            cout << "\n";
        } else {
            cout << "-1\n";
        }
    }
    return 0;
}