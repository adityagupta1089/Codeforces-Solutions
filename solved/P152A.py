from itertools import count
n, m = map(int, input().split())
ss = []
mat = []
for _ in range(n):
    mat.append(input())
for i in range(m):
    maxl = max([int(x[i]) for x in mat])
    for j in range(n):
        if (int(mat[j][i]) == maxl) and not (j in ss):
            ss.append(j)
print(len(ss))
