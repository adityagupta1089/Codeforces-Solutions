n , m = map(int, input().split())
mat = []
for i in range(n):
    row = input()
    x = ''
    for j in range(m):
        if row[j] == '.':
            x += 'B' if (i+j) % 2 == 0 else 'W'
        else:
            x += '-'
    mat.append(x)
print('\n'.join(mat))
