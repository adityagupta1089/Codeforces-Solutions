n, m, i, j, a, b = map(int, input().split())
p = [(1, m), (n, 1), (n, m), (1, 1)]
c = 0
mn = 1e9
fnd = False
for c in range(4):
    if abs(p[c][0] - i) % a == 0 and abs(p[c][1] - j) % b == 0 and ((p[c][0] - i) / a + (p[c][1] - j) / b) % 2 == 0:
        a1 = abs(p[c][0] - i) / a
        b1 = abs(p[c][1] - j) / b
        if (1 <= i - a or i + a <= n or max(a1, b1) == 0)and(1 <= j - b or j + b <= m or max(a1, b1) == 0) :
            mn = min(mn, int(max(a1, b1)))
            fnd = True
if fnd:
    print(mn)
else:
    print('Poor Inna and pony!')
