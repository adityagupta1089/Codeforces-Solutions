import math
y, k, n = map(int, input().split())
# x+y<n k|x+y x+y=ka ka<n a<n/k a= 0 to floor(n/k)
# ki-y>=1 i>=(y+1)/k
l = [k * i - y for i in range(math.ceil((y + 1) / k), n // k+1)]
if len(l) is 0:
    print(-1)
else:
    print(' '.join(map(str, l)))
