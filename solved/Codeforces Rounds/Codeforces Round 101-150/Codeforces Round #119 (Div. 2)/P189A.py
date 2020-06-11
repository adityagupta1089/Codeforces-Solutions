n, a, b, c = map(int, input().split())
dp=[0]+[-1e19]*4000
for i in range(1,n+1):
    dp[i]=max(dp[i-a],dp[i-b],dp[i-c])+1
print(dp[n])