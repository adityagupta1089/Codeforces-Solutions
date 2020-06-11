from math import ceil, sqrt
n = int(input())
k = 1
x = 2
cnt = 0
while k != n + 1:
    posnum = (k + 1) * max(ceil(x / (k + 1)), ceil(sqrt(x) / (k + 1)))
    while (posnum ** 2 - x) % k != 0:
        posnum += k + 1
    print(int( (posnum ** 2 - x) / k))
    k += 1
    x = posnum
