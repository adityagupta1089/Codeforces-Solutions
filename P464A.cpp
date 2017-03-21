#include <iostream>
#include <stdio.h>
#include <string>
using namespace std;

int add(char *t, int pos, int bas) {
  char next = t[pos] + 1;
  while ((pos - 1 >= 0 && t[pos - 1] == next) ||
         (pos - 2 >= 0 && t[pos - 2] == next))
    next++;
  if (pos == 0 && next - 'a' >= bas)
    return -1;
  while (next - 'a' >= bas) {
    next = 'a';
    if (add(t, pos - 1, bas) != 0) {
      return -1;
    }
    while ((pos - 1 >= 0 && t[pos - 1] == next) ||
           (pos - 2 >= 0 && t[pos - 2] == next))
      next++;
  }
  t[pos] = next;
  return 0;
}

int main() {
  int n, p;
  cin >> n >> p;
  char s[2000];
  scanf("%s", s);
  if (add(s, n - 1, p) != -1) {
    printf("%s\n", s);
  } else {
    printf("NO\n");
  }
  return 0;
}
