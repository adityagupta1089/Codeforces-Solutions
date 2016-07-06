r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
a = b = c = d = -1
for a in range(1, 21):
    b = r1 - a
    if c1 - a is d2 - b:
        c = c1 - a
    else:
        continue
    if r2 - c is d1 - a and d1 - a is c2 - b:
        d = r2 - c
    else:
        continue
    if a is not b and a is not c and a is not d and b is not c and b is not d and c is not d and 1 <= a <= 9 and 1 <= b <= 9 and 1 <= c <= 9 and 1 <= d <= 9:
        print(str(a) + " " + str(b) + "\n" + str(c) + " " + str(d))
    else:
        continue
    exit(0)
print(-1)
    
