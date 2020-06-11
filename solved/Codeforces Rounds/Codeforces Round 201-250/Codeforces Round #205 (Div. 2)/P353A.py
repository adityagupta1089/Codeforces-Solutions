n = int(input())
a = [];b = []
eo = oe = False
for _ in range(n):
    a1, b1 = map(int, input().split())
    a.append(a1)
    b.append(b1)
    if a1 % 2 == 0 and b1 % 2 != 0:
            eo = True
    elif a1 % 2 != 0 and b1 % 2 == 0:
            oe = True
asum = sum(a)
bsum = sum(b)
if asum % 2 != bsum % 2:
    print(-1)
elif asum % 2 == 0:
    print(0)
elif eo or oe:        
    print(1)
else:
    print(-1)       
