#boj1197

# 집의 갯수 / 길의 갯수 입력
n, m = map(int, input().split())

edgeInfo = []
parent = []

for i in range(n+1):
    parent.append(-1)

for i in range(m):
    u, v, w = map(int, input().split())
    edgeInfo.append([u, v, w])

# edge 값 weight 기준으로 sort
edgeInfo = sorted(edgeInfo, key=lambda x : x[2])

edge = 0
tot = 0

for u, v, w in edgeInfo:
    if u > v:
        u, v = v, u
    tempV = v
    while parent[tempV] != -1:
        if parent[tempV] == u:
            break
        tempV = parent[tempV]
    if parent[tempV] != u:
        parent[v] = u
        tot += w

print(tot)

