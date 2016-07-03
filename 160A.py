l=int(input())
s=[int(x) for x in input().split()]
m=sum(s)
s.sort()
v=0
for i in range(l):
    v+=s[l-i-1]
    if 2*v>m:
        break
print(i+1)
