from math import sqrt


a, b, c = map(int, input().split())
print(int(round(4 * sqrt(a * b * c) * (1 / a + 1 / b + 1 / c))))
