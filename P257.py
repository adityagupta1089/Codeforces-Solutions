n, m, k = map(int, input().split())
a = list(map(int, input().split()))
a = sorted(a, reverse=True)
for i in range(n + 1):
    if i < n and k < m:
        k += a[i] - 1
    else:
        break;
if k >= m: 
    print(i)
else:
    print(-1)
