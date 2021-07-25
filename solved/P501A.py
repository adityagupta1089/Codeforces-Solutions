a, b, c, d = map(int, input().split())
p1 = max(3 * a / 10, a - a * c / 250)
p2 = max(3 * b / 10, b - b * d / 250)
if p1 > p2:
    print ("Misha")
elif p1 == p2:
    print ("Tie")
else:
    print ("Vasya")
