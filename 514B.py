n, x0, y0 = map(int, input().split())
m = []
for _ in range(n):
    x, y = map(int, input().split())
    sl = (y - y0) / (x - x0) if x != x0 else "Inf"
    if not sl in m:
        m.append(sl)
print(len(m))
