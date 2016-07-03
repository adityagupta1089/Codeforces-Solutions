n = int(input())
b = dict()
for x in list(map(int, input().split())):
    if x not in b.keys():
        b[x] = 1
    else:
        b[x] += 1
if any(b[x] > (n + 1) / 2 for x in b.keys()):
    print('NO')
else:
    print('YES')
