import math
n = int(input())
v = math.floor((-1 + math.sqrt(1 + 8 * n)) / 2)
for i in range(v, 0, -1):
	z = n - i * (i + 1) / 2
	# 2z=a*(a+1) a^2+a-2z=0
	a = (-1 + math.sqrt(1 + 8 * z)) / 2
	if a.is_integer() and a > 0:
		print("YES")
		exit(0)
print("NO")
