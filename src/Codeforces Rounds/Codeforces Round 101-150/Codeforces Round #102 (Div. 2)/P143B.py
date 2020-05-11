import math
num = input()
if '.' not in num:
    num += '.00'
ip, dp = num.split(".")
neg = False
if ip[0] == '-':
    neg = True
    ip = ip[1:]
if len(dp) > 2:
    dp = dp[:2]
while len(dp) < 2:
    dp += "0"    
i = 0
while i < len(ip) and ip[i] == '0':
    i += 1
ip = ip[i:]
if len(ip) > 3:
    ip = ip[::-1]
    ip = ','.join(ip[3 * i :min(3 * i + 3, len(ip))] for i in range(math.ceil(len(ip) / 3)))
    ip = ip[::-1]
if len(ip) == 0:
    ip = '0'
    if int(num.split('.')[1]) == 0:
        neg = False
if neg:
    print('(', end='')
print('$' + ip + '.' + dp, end='')
if neg:
    print(')', end='')
