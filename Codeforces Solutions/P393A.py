st = input()
a = {'n':0, 'i':0, 'e':0, 't':0}
# n*3131-(n-1)*1000 = 2n+1,n,3n,n
for c in st:
    if c in a:
        a[c] += 1
print(max(min([(a['n'] - 1) // 2, a['i'], a['e'] // 3, a['t']]), 0))
