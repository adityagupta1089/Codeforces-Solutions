#include <algorithm>
#include <cstring>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        int x = n / 3;
        int mindiff = 10;
        int c1 = 0;
        int c2 = 0;
        for (int i1 = x - 3; i1 <= x + 3; i1++)
        {
            for (int i2 = x - 3; i2 <= x + 3; i2++)
            {
                if (i1 + 2 * i2 == n && abs(i2 - i1) < mindiff)
                {
                    c1 = i1;
                    c2 = i2;
                    mindiff = abs(i2 - i1);
                }
            }
        }
        printf("%d %d\n", c1, c2);
    }
    return 0;
}