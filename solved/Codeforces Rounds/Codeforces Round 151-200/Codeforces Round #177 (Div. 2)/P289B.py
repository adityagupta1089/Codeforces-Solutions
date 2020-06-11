n, m, d = map(int, input().split())
mat = []
for _ in range(n):
    for x in list(map(int, input().split())):
        mat.append(x)
x = mat[0] % d
for y in mat:
    if y % d != x:
        print(-1)
        exit(0)
mat = [(y - x) / d for y in mat]
mat.sort()
med = mat[int((m * n) / 2)]
print(int(sum([abs(y - med) for y in mat])))
