n = int(input())
xset = set()
yset = set()
l = list(tuple(map(int, input().split())) for _ in range(n))
for a in l:
    xset.add(a[0])
    yset.add(a[1])
print(min(len(xset), len(yset)))
