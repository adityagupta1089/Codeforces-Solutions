p=False
n=int(input())
for i in [4,7,44,47,74,77,444,447,474,477,744,747,774,777]:
    if i>n:break
    if n%i is 0:
        p=True
        break
if p:
    print("YES")
else:
    print("NO")
