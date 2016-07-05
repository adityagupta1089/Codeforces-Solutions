k = int(input())
lines = [input() for _ in range(4)]
cnt = dict()
for x in lines:
    for c in x:
        if c not in cnt:
            cnt[c] = 1
        else:
            cnt[c] += 1
if '.' in cnt:
    cnt.pop('.')
for u in cnt:
    if cnt[u] > 2 * k:
        print('NO')
        exit(0)
print('YES')
