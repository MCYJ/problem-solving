# madaniel47
# 1181

n = int(input())
lst = []

for _ in range(n):
    word = input()
    lst.append([len(word), word])
lst.sort()
i = 0
nlst = [lst[i]]
while i < len(lst)-1:
    if lst[i][0] == lst[i+1][0]:
        nlst[i]
    i = i + 1

print(lst)

