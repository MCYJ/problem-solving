#23080
#author madaniel47

k = int(input())
s = input()
result = s[0]
for i in range(1,len(s)):
    if i%k == 0:
        result += s[i]
print(result)