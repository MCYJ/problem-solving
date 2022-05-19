n, m = map(int, input().split())
subjectList = [1 for _ in range(n+1)]
abList = []
for i in range(m):
    a, b = map(int, input().split())
    abList.append([a,b])

# a, b 순서대로 정렬
abList.sort()

for a, b in abList:
    if subjectList[a] == subjectList[b]:
        subjectList[b] = subjectList[a] + 1
    elif subjectList[a] > subjectList[b]:
        subjectList[b] = subjectList[a]+1
    else:
        pass

for i in range(1,len(subjectList)):
    if i != len(subjectList)-1:
        print(subjectList[i], end=" ")
    else:
        print(subjectList[i])