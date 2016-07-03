n = int(input())
w = [tuple(input().split())for _ in range(n)]
x = dict()
y = dict()
z = dict()
def add(e, d):
    if not e in d:
        d[e] = 1
    else:
        d[e] += 1
def pr(d):
    return sum(u * (u - 1) / 2 for u in d.values())
for a in w:
    add(a[0], x)
    add(a[1], y)
    add(a, z)
cnt = pr(x) + pr(y) - pr(z)
print(int(cnt))
