str1 = input()
str2 = input()
cnt1 = dict()
cnt2 = dict()
for x in str1:
    if x not in cnt1.keys():
        cnt1[x] = 0
    cnt1[x] += 1
for x in str2:
    if x not in cnt2.keys():
        cnt2[x] = 0
    cnt2[x] += 1
s = 0
for x in cnt2.keys():
    if x not in cnt1.keys():
        print(-1)
        exit(0)
    s += min(cnt1[x], cnt2[x])
print(s)
