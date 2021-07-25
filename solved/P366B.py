n, k = map(int, input().split())
a = list(map(int, input().split()))
ind = [x for x in range(0,n,k)]
m=1e8
mi=0
for i in range(0,k):
    x=sum(a[i+j] for j in ind)
    if x<m:
        m=x
        mi=i 
print(mi+1)