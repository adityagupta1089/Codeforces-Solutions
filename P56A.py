n = int(input())
cnt = 0
for _ in range(n):
    s=input()
    if s.isdecimal(): 
        if int(s) < 18:
            cnt += 1
    elif s in ['ABSINTH', 'BEER', 'BRANDY', 'CHAMPAGNE', 'GIN', 'RUM', 'SAKE', 'TEQUILA', 'VODKA', 'WHISKEY', 'WINE']:
        cnt += 1
print(cnt)
