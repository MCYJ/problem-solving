#author madaniel47

n = int(input())
arr = []
maxLevel = 0
maxSafeZone = 1

for i in range(n):
    row = list(map(int, input().split()))
    maxLevel = max(max(row), maxLevel)
    arr.append(row)

visited = [[0 for i in range(n)] for j in range(n)]

def doSearch():
    while len(pointStack) != 0:
        r, c = pointStack.pop(0)
        if r < 0 or r >= n or c < 0 or c >= n:
            continue
        if nowVisited[r][c] == 1:
            continue
        nowVisited[r][c] = 1

        # 상하좌우 방향 리스트
        directions = [[r+1, c],[r-1, c],[r, c+1],[r, c-1]]

        for direction in directions:
            pointStack.append(direction)




# 모든 value에서 nowLevel을 빼서 생각
# nowLevel: 1 ~ (maxLevel-1)
for nowLevel in range(1, maxLevel):
    safeZone = 0
    nowVisited = [[0 for i in range(n)] for j in range(n)]

    pointStack = []
    # nowVisited 에 잠긴영역 표시
    for i in range(n):
        for j in range(n):
            if (arr[i][j] - nowLevel) <= 0:
                nowVisited[i][j] = 1
                
    


    for i in range(n):
        for j in range(n):
            if nowVisited[i][j] == 0:
                pointStack.append([i, j])
                doSearch() 
                safeZone = safeZone + 1
    
    # maxSafeZone: 가장 많은 안전지대 저장
    maxSafeZone = max(maxSafeZone, safeZone)
        
print(maxSafeZone)