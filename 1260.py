n, m, v = map(int, input().split())

visited = []
def dfs(x):
    global visited
    global nodeList
    if x in visited:
        return
    else:
        visited.append(x)
        print(x, end=' ')
        for y in nodeList[x]:
            dfs(y)

nodeList = []
for _ in range(n+1):
    nodeList.append([])
for _ in range(m):
    node = list(map(int, input().split()))
    nodeList[node[0]].append(node[1]) 
    nodeList[node[1]].append(node[0])
    nodeList[node[0]].sort()
    nodeList[node[1]].sort()
# DFS

dfs(v)

print()

# BFS
visited = []
queue = []
queue.append(v)
visited.append(v)
while queue:
    node = queue.pop(0)
    print(node, end=' ')
    
    for i in range(len(nodeList[node])):
        if nodeList[node][i] not in visited:
            queue.append(nodeList[node][i])
            visited.append(nodeList[node][i])

