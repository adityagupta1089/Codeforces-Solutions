n = int(input())
m, M = map(int, input().split())
x = set((i, i + 1) for i in range(m, M))
for _ in range(n - 1):
    a, b = map(int, input().split())
    for i in range(a, b):
        if (i, i + 1) in x:
            x.remove((i, i + 1))
print(len(x))
