v = int(input())
a = list(map(int, input().split()))
m = list(enumerate(a, 1))
k = sorted(m, key=lambda x:(-x[1], x[0]))[-1]
t = v // k[1]
v -= t * k[1]
num = [k[0]] * t
for i in range(t):
    if v + k[1] > min(a):
        num[i] = list(q for q in m if q[1] <= v + k[1])[-1][0]
        v -= a[num[i] - 1] - k[1]
    else:
        break;
print(''.join(map(str, num)) or -1)
