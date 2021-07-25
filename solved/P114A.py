from math import log
n = int(input())
m=int(input())
imp = -1
i=0
while m>=n and m%n==0:
    m/=n
    i+=1
if m==1:
    imp=i 
if imp!=-1:
    print("YES")
    print(int(imp)-1)
else:
    print("NO")        
