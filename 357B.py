n, m = map(int, input().split())
mat = [(input().split()) for _ in range(m)]
col = [-1 for _ in range(n)]
col[int(mat[0][0]) - 1] = 1
for d in mat:
    cols = [1, 2, 3]
    for x in d:   
        if col[int(x) - 1] != -1:
            cols.remove(col[int(x) - 1])
    for x in d:   
        if col[int(x) - 1] == -1:
            col[int(x) - 1] = cols[0]
            cols.remove(cols[0])
    prev = d
print(' '.join(map(str, col)))
