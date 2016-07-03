str1=input()
str2=input()
cnt=0
j=0
for i in range(len(str2)):
    if str2[i]==str1[j]:
        j+=1
print(j+1)