n = int(input())
a = sorted(list(map(int, input().split())))
b = set()
for x in a:
    if all(all(('%03d' % x)[i] == '0' or ('%03d' % t)[i] == '0' for i in range(3))for t in b):
        b.add(x)
print(len(b))
print(' '.join(map(str, b)))
