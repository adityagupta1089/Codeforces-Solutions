inp=input()
j=0
msg="hello"
for i in range(len(inp)):
    if inp[i] is msg[j]:
        j+=1
    if j is 5:
        print("YES")
        break
if j is not 5:
    print("NO")