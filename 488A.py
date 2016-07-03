n = int(input())
for i in range(1, abs(8888888888 - n) + 1):
    if any(x == '8' for x in str(n + i)):
        print(i)
        exit(0)
print(-1)
