n = int(input())
nums = list(map(int, input().split()))
L = [1] + [0] * (n - 1)
R = [0] * (n - 1) + [1]
for i in range(1, n):
    L[i] = 1  if  nums[i - 1] > nums[i] else 1 + L[i - 1]
for i in range(n - 2, -1, -1):
    R[i] = 1  if nums[i] < nums[i + 1] else 1 + R[i + 1]
print(max(L[i] + R[i] for i in range(n)) - 1)
