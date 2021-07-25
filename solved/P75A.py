a = input()
b = input()
if int(a.replace('0', '')) + int(b.replace('0', '')) == int(str(int(a) + int(b)).replace('0', '')):
    print('YES')
else:
    print('NO')
