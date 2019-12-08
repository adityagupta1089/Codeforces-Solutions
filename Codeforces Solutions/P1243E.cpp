#ifdef ONLINE_JUDGE

#define DEBUG 0
#include <bits/stdc++.h>

#else

#define DEBUG 1

#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <queue>

#endif

using namespace std;

int main() {
    if (!DEBUG)
        ios::sync_with_stdio(false);
    unsigned int k;
    scanf("%d", &k);
    vector<int> boxes[k];
    int64_t sm = 0, sms[k];
    fill(sms, sms + k, 0);
    unordered_map<int, unsigned int> pos;
    for (int i = 0; i < k; i++) {
        int n;
        scanf("%d", &n);
        boxes[i].resize(n);
        for (int j = 0; j < n; j++) {
            scanf("%d", &boxes[i][j]);
            sm += boxes[i][j];
            sms[i] += boxes[i][j];
            pos[boxes[i][j]] = i;
        }
    }
    if (sm % k != 0) {
        printf("No\n");
    } else {
        int64_t avg_sm = sm / k;
        int64_t offsets[k];
        for (int i = 0; i < k; i++) {
            offsets[i] = avg_sm - sms[i];
        }
        unordered_map<int, int> next_val;
        for (auto kv: pos) {
            int val = kv.first;
            int box = kv.second;
            int64_t __next_val = val + offsets[box];
            if ((int) __next_val != __next_val) {
                continue;
            }
            int _next_val = (int) __next_val;
            if (pos.find(_next_val) == pos.end())
                continue;
            if (_next_val == val || pos[_next_val] != box)
                next_val[val] = _next_val;
            if (DEBUG)
                printf("%d [%d] -> %d [%d]\n", val, box, _next_val, pos[_next_val]);
        }
        // find cycles
        unordered_set<int> visited;
        unordered_map<unsigned int, vector<int>> cycles;
        for (auto kv:next_val) {
            // start dfs
            int start = kv.first;
            if (visited.find(start) != visited.end()) {
                continue; // Removed Node
            }
            int curr = start;
            unordered_set<int> visited_dfs;
            visited_dfs.insert(curr);
            do {
                if (next_val.find(curr) == next_val.end()) {
                    break; // Dead End
                }
                curr = next_val[curr];
                if (visited.find(curr) != visited.end()) {
                    break; // Removed Node
                }
                if (visited_dfs.find(curr) == visited_dfs.end()) {
                    // New Node
                    visited_dfs.insert(curr);
                } else {
                    //Back Edge
                    unsigned int cycle_id = 0;
                    vector<int> cycle;
                    int start_cycle = curr;
                    int curr_cycle = start_cycle;
                    bool valid = true;
                    do {
                        if (cycle_id >> pos[curr_cycle] & 1u) {
                            valid = false;
                            break;
                        }
                        cycle_id |= 1u << pos[curr_cycle];
                        cycle.push_back(curr_cycle);
                        curr_cycle = next_val[curr_cycle];
                    } while (curr_cycle != start_cycle);
                    if (valid) {
                        cycles[cycle_id] = cycle;
                    }
                    break;
                }
            } while (true);
            for (int x: visited_dfs) {
                visited.insert(x); // Remove Node
            }
        }
        // set cover
        unsigned int mx = 1u << k;
        bool covered[mx];
        unordered_map<unsigned int, unsigned int> sub_cover;
        fill(covered, covered + mx, false);
        covered[0] = true;
        for (unsigned int i = 0; i < mx; i++) {
            for (unsigned int j = i; j > 0; j = (j - 1) & i) {
                if (cycles.find(j) != cycles.end() && covered[i & ~j]) {
                    covered[i] = true;
                    sub_cover[i] = j;
                    break;
                }
            }
        }
        //print answer
        if (covered[mx - 1]) {
            printf("Yes\n");
            queue<unsigned int> bfs;
            bfs.push(mx - 1);
            pair<int, int> sol[k];
            while (!bfs.empty()) {
                unsigned int top = bfs.front();
                if (cycles.find(top) != cycles.end()) {
                    for (int ck:cycles[top]) {
                        sol[pos[next_val[ck]]] = make_pair(next_val[ck], pos[ck] + 1);
                    }
                } else {
                    bfs.push(sub_cover[top]);
                    bfs.push(top & ~sub_cover[top]);
                }
                bfs.pop();
            }
            for (auto ab:sol) {
                printf("%d %d\n", ab.first, ab.second);
            }
        } else {
            printf("No\n");
        }
    }
    return 0;
}