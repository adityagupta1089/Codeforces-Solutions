n = int(input())
n2 = n
m = dict()
pri = dict()
for x in range(2,n+1):
    pri[x]=True
for x in range(2,n+1):
    if pri[x]:
        for y in range(x*x,n+1,x):
            pri[y]=False
for x in range(2, n + 1):
    if pri[x]:
        m[x] = 0
        while n % x == 0:
            m[x] += 1
            n /= x
    if n == 1:
        break
for k in sorted(m.keys(), key=lambda x:m[x], reverse=True):
    for _ in range(m[k]):
        print(int(n2), end=' ')
        n2 /= k
print(1)
