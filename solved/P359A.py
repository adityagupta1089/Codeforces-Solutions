n, m = map(int, input().split())
mat = [list(map(int, input().split())) for _ in range(n)]
for i in range(1, m - 1):
    if mat[0][i] is 1:
        print(2)
        exit(0)
for i in range(1, n - 1):
    if mat[i][0] is 1:
        print(2)
        exit(0)
for i in range(1, n - 1):
    if mat[i][m - 1] is 1:
        print(2)
        exit(0)
for i in range(1, m - 1):
    if mat[n - 1][i] is 1:
        print(2)
        exit(0)
print(4)
