n = int(input())
goals = {}
for _ in range(n):
    team = input()
    if team not in goals.keys():
        goals[team] = 1
    else:
        goals[team] += 1
print(sorted(goals, key=lambda x:goals[x])[-1])
