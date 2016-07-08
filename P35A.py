with open('input.txt', 'r') as f:
    data = f.readlines()
n = int(data[0])
for v in range(3):
    a, b = map(int, data[1 + v].split())
    if a == n:
        n = b
    elif b == n:
        n = a
with open('output.txt', 'w+') as f:
    f.write(str(n))
        
