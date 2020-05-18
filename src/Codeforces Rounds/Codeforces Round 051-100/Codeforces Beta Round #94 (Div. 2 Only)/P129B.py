from collections import defaultdict


n, m = map(int, input().split())
E = [tuple(map(int, input().split())) for _ in range(m)]
adj = defaultdict(set)
for e in E:
    adj[e[0]].add(e[1])
    adj[e[1]].add(e[0])
dl = defaultdict(set)
for v in adj:
    dl[len(adj[v])].add(v)
if len(dl[1]) == 0:
    print('0')
else:
    cnt = 0
    while len(dl[1]) > 0:
        dec = defaultdict(lambda: [list(), 0])
        while len(dl[1]) > 0:
            v = dl[1].pop()
            for v2 in adj[v]:     
                dec[v2][0].append(v)
                dec[v2][1] += 1                                      
            del adj[v]  
        for v2 in dec:
            if v2 in dl[len(adj[v2])]:
                dl[len(adj[v2])].remove(v2)
                dl[len(adj[v2]) - dec[v2][1]].add(v2)     
                for x in dec[v2][0]:  
                    adj[v2].remove(x)    
        cnt += 1
    print(cnt)
