# x1-x2+x3...+/-xn = d and 1<=xi<=l for all i
# n d l
# 3 3 2 => x1-x2+x3=2 1<=xi<=3 1-1+2
# n is even x1-x2+...x(m-1)-xm=d
n,d,l=map(int,input().split())
m=(n//2)*(1-l)
M=(n//2)*(l-1)
if n%2!=0:
        m+=1
        M+=l
if not (m<=d<=M):
        print(-1)
else:
        e = d-m
        l2=[1 if i%2==0 else l for i in range(n)]
        ci=0
        while e>0:
                if ci%2==0:
                        l2[ci]+=min(l-1,e)                        
                else:
                        l2[ci]-=min(l-1,e)
                if ci+2<n:
                        ci+=2
                else:
                        ci=1
                e-=min(l-1,e)
        for e in l2:
                print(e,end=' ')
