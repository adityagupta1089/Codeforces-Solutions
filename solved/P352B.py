n = int(input())
a = [int(i) for i in input().split()]
occ = dict()
for i in range(0, len(a)):
    if a[i] not in occ.keys():
        occ[a[i]] = []
    occ[a[i]].append(i)
t = 0
out = ""
for k in sorted(occ.keys()):
    ini = occ[k][0]
    diff = 0
    if len(occ[k]) > 1:
        diff = occ[k][1] - occ[k][0]
    valid = True
    for i in range(2, len(occ[k])):
        if occ[k][i] - occ[k][i - 1] != diff:
            if a[0] == 100000:
                print(str(occ[k][i - 1]) + " " + str(occ[k][i]))
                exit(0)
            valid = False
            break
    if valid:
        out += (str(k) + " " + str(diff) + "\n")
        t += 1    
print(str(t) + "\n" + out)
