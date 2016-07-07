n = int(input())
a = list(map(int, input().split()))
for i in range(n):
    for j in range(i + 1 , n):
        for k in range(j + 1 , n):
            if a[i] + a[j] == a[k]:
                print(str(k + 1) + " " + str(j + 1) + " " + str(i + 1))
                exit(0)
            elif a[k] + a[j] == a[i]:
                print(str(i + 1) + " " + str(j + 1) + " " + str(k + 1))
                exit(0)
            elif a[i] + a[k] == a[j]:
                print(str(j + 1) + " " + str(k + 1) + " " + str(i + 1))
                exit(0)
print(-1)
