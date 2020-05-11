n = int(input())
a = [int(x) for x in input().split()]     
while any(x != a[0] for x in a):
    a.sort()
    a = [a[i] - a[0] if a[i] > a[0] else a[i] for i in range(0, n)]
print(sum(a))
