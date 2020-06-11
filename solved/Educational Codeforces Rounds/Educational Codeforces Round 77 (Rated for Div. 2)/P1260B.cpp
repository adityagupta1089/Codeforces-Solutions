#include <iostream>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int a, b;
        cin >> a >> b;
        // a-=x, b-=2xx
        // a-=2x, b-=x
        // a=  x1+x2+...xn   + 2(y1+y2+...ym)
        // b= 2(x1+x2+...xn) +  (y1+y2+...ym)
        // a = A  + 2B
        // b = 2A +  B
        // a+b = 3 (A+B)
        // A+B = (a+b)/3
        // A = b-(a+b)/3=(2b-a)/3
        // B = a-(a+b)/3=(2a-b)/3
        // 6,9 -> A=2+6=8; B=4+3=7
        if (2 * b >= a && 2 * a >= b && (2 * b - a) % 3 == 0 && (2 * a - b) % 3 == 0) {
            cout << "YES\n";
            //cout << (a + 2 * b) / 3 << " " << (2 * a + b) / 3 << "\n";
        } else {
            cout << "NO\n";
        }
    }
}