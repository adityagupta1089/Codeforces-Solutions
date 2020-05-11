#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, m;
    scanf("%d %d", &n, &m);
    vector<int> nxt[n];
    bool adj[n][n] ;
    fill(&adj[0][0],&adj[0][0]+sizeof(adj), 0);
    for (int i=0;i<m;i++){
        int u, v;
        scanf("%d %d", &u, &v);
        adj[u-1][v-1]=true;
        nxt[u-1].push_back(v-1);
    }
    long long sol = 0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            long long cnt = 0;
            if (i!=j){
                for(int k:nxt[i]){
                    if (adj[k][j])cnt++;
                }
            }
            sol += cnt * (cnt - 1) / 2;
        }
    }
    printf("%lld\n",sol);
}