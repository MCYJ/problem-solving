#boj1647

def UNION(a,b):
    root1 = FIND(a)
    root2 = FIND(b)
    if root1 != root2:
        parent[root1] = root2

def FIND(curr):
    if parent[curr] == -1:
        return curr
    while parent[curr] != -1:
        curr = parent[curr]
    return curr

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
    if FIND(u) == FIND(v):
        continue
    if edge != n-2:
        UNION(u, v)
        tot += w
        edge += 1
    else:
        break

print(tot)

