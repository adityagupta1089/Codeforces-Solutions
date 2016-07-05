n,k=map(int,input().split())
for i in range(n):
    for j in range(n):
        print('0' if i is not j else str(k),end=' ')
    print()