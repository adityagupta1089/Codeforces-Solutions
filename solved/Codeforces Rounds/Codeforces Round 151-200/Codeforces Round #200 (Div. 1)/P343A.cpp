#include <iostream>

using namespace std;

int main() {
  long long a, b;
  cin >> a >> b;
  long long cnt = 0;
  while (a != 0 && b != 0) {
    if (a >= b) {
      cnt += a / b;
      a %= b;
    } else if (a < b) {
      cnt += b / a;
      b %= a;
    }
  }
  cout << cnt << "\n";
  return 0;
}
