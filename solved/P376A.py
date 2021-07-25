s = input()
p = s.find("^")
x = list(range(-p, len(s) - p))
w = sum(0 if s[i] is '=' or s[i] is '^' else int(s[i]) * x[i] for i in range(len(s))) 
if w < 0:
    print("left")
elif w is 0:
    print("balance")
else:
    print("right")
