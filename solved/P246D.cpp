#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

int main() {
  int n, m;
  cin >> n >> m;
  int c[n];
  unordered_map<int, unordered_set<int>> diversity;
  int max_col = -1;
  for (int i = 0; i < n; i++) {
    cin >> c[i];
    max_col = max(max_col, c[i]);
    diversity[c[i]] = {};
  }
  for(int i=0;i<m;i++){
    int a, b;
    cin >> a >> b;
    --a;
    --b;
    if (c[a]!=c[b]){
      diversity[c[a]].insert(c[b]);
      diversity[c[b]].insert(c[a]);
    }
  }
  int largest = 0;
  int col = max_col;
  for (auto k : diversity){
    //cout << k.first << ", " << k.second.size() << "\n";
    if (k.second.size() > largest) {
      largest = k.second.size();
      col = k.first;
    } else if (k.second.size() == largest && k.first < col) {
      col = k.first;
    }
  }
  cout << col << "\n";
}
