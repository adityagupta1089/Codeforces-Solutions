n = int(input())
a = [int(x) for x in input().split()]     
n = [];p = [];z = [];tr = [];
for x in a:
    if x == 0: z.append(x)
    elif x > 0: p.append(x)
    elif x < 0: 
        if len(n) == 0:
            n.append(x)
        elif len(tr) < 2:
            tr.append(x)
        else:
            z.append(x)
if len(p)==0:
    p=p+tr
else:
    z=z+tr
print(str(len(n)) + ' ' + ' '.join(str(x) for x in n))
print(str(len(p)) + ' ' + ' '.join(str(x) for x in p))
print(str(len(z)) + ' ' + ' '.join(str(x) for x in z))
