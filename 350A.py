input()
a = list(map(int, input().split()))
b = list(map(int, input().split()))
v=max(2*min(a),max(a))
if v>=min(b):
    print(-1)
else:
    print(v)