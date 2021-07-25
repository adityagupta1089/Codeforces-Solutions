#include <iostream>
#include <set>
#include <vector>

using namespace std;

struct node {
  int id;
  set<int> nbh;
};

vector<int> op;

int dfs(int n, node *nodes, int root, int *init, int *fin, int even_op,
        int odd_op, int lev) {
  int operations = 0;
  if ((lev % 2 == 0 && (fin[root] + even_op) % 2 != init[root])) {
    even_op++;
    operations++;
    op.push_back(root + 1);
  }
  if ((lev % 2 != 0 && (fin[root] + odd_op) % 2 != init[root])) {
    odd_op++;
    operations++;
    op.push_back(root + 1);
  }
  for (set<int>::iterator it = nodes[root].nbh.begin();
       it != nodes[root].nbh.end(); it++) {
    nodes[*it].nbh.erase(root);
    operations += dfs(n, nodes, *it, init, fin, even_op, odd_op, lev + 1);
  }
  return operations;
}

int main() {
  int n;
  cin >> n;
  node nodes[n];
  for (int i = 0; i < n; i++) {
    nodes[i].id = i;
  }
  for (int i = 0; i < n - 1; i++) {
    int u, v;
    cin >> u >> v;
    nodes[u - 1].nbh.insert(v - 1);
    nodes[v - 1].nbh.insert(u - 1);
  }
  int init[n];
  int fin[n];
  for (int i = 0; i < n; i++)
    cin >> init[i];
  for (int i = 0; i < n; i++)
    cin >> fin[i];
  cout << dfs(n, nodes, 0, init, fin, 0, 0, 0) << "\n";
  for (int i = 0; i < op.size(); i++) {
    cout << op[i] << "\n";
  }
}
