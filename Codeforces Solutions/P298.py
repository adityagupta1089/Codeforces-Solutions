n = int(input())
s = input()
p1 = 0
p2 = n - 1
pi = -1
c1 = 'X'
c2 = 'X'
p = '.'
for i in range(n):
    if s[i] is not '.' and (p is '.' or i is 0):
        c1 = s[i]
        p1 = i
    elif s[i] is not '.' and s[i] is not c1:
        c2 = s[i]
    elif p is not '.' and s[i] is '.':
        p2 = i - 1        
    if s[i] is not p and p is not '.' and s[i] is not '.':
        pi = i - 0.5
    p = s[i]
p1 += 1
p2 += 1
pi += 1
if c1 is 'R':
    if c2 is 'X':
        print(str(p1) + " " + str(p2 + 1))
    else:
        print(str(p1) + " " + str(int(pi - 0.5)))
else:
    if c2 is 'X':
        print(str(p2) + " " + str(p1 - 1))
    else:
        print(str(p2) + " " + str(int(pi + 0.5)))
