m, n = map(int, input().split())
mat = [list(map(int, input().split())) for _ in range(m)]
t = [[0] * m for _ in range(n)]
for p in range(n):
    for i in range(m):
            t[p][i] = max(t[p - 1][i] if p > 0 else 0, t[p][i - 1]) + mat[i][p]
print(' '.join(map(str, t[n - 1])))
