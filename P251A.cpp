#include <iostream>

using namespace std;

int main() {
  long long n, d;
  cin >> n >> d;
  long long v = 0;
  long long pts[n];
  for (long long i = 0; i < n; i++) {
    cin >> pts[i];
  }
  if (n < 3) {
    cout << 0 << "\n";
    return 0;
  }
  long long j = 2;
  for (long long i = 0; i < n - 2; i++) {
    while (j + 1 < n && pts[j + 1] - pts[i] <= d)
      j++;
    if (pts[j] - pts[i] <= d) {
      long long ele = j - i;
      // cout << "Pair: " << i << ", " << j << "\n";
      v += ele * (ele - 1) / 2;
    }
  }
  cout << v << "\n";
}
