#include <iostream>

using namespace std;


long long modPow(int x, long long n, long long p) {//O(log n)
	if (n == 1)
		return x;
	else if ((n & 1) == 0) {
		long long val = modPow(x, n / 2, p);
		return (val * val) % p;
	} else {
		return (x * modPow(x, n - 1, p)) % p;
	}
}

int main() {
			int a,b,n;
			cin >> a >> b >> n;
			long long M = (long long) 1e9 + 7;
			long long sum = n * a;
			long long ways = 1;
			long long totalWays = 0;
			for (int i = 0; i <= n;) {
				bool valid = true;
				long long sum1 = sum;
				do {
					int d = (int) (sum1 % 10);
					if (d != a && d != b) {
						valid = false;
						break;
					}
					sum1 /= 10;
				} while (sum1 != 0);
				if (valid) {
					totalWays += ways;
				}
				i++;
				sum += (b - a);
				ways *= (n - i + 1);
				ways %= M;
				ways *= modPow(i, M - 2, M);
				ways %= M;
			}
			cout << (totalWays % M);
			return 0;
		}


