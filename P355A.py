k, d = map(int, input().split())
if d is not 0:
    print(str(d), end='')
    for _ in range(k - 1):
        print('0', end='')
else:
    if k is 1:
        print('0')
    else:
        print('No solution')
