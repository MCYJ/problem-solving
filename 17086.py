#author madaniel47

n, m = map(int, input().split())
arr = [[0 for i in range(m)] for j in range(n)]
sharkList = []

for i in range(n):
    nums = list(map(int, input().split()))
    for j in range(m):
        if nums[j] == 1:
            arr[i][j] = -1
            sharkList.append((i,j))

for i, j in sharkList:
    pointList = []
    weight = 1

    pointList.append((i+1, j))
    pointList.append((i+1, j-1))
    pointList.append((i+1, j+1))
    pointList.append((i-1, j))
    pointList.append((i-1, j-1))
    pointList.append((i-1, j+1))
    pointList.append((i, j-1))
    pointList.append((i, j+1))
    pointList.append((-2, -2))

    while len(pointList) != 0:
        r, c = pointList.pop(0)
        if r == -2 and c == -2:
            weight = weight + 1
            if len(pointList) == 0:
                break
            pointList.append((-2, -2))
            continue
        if r < 0 or r >= n or c < 0 or c >= m:
            continue
        # 상어의 위치인 경우
        if arr[r][c] == -1:
            continue
        
        if arr[r][c] == 0:
            arr[r][c] = weight
        elif arr[r][c] <= weight:
            continue
        else:
            arr[r][c] = weight
            

        pointList.append((r+1, c))
        pointList.append((r+1, c-1))
        pointList.append((r+1, c+1))
        pointList.append((r-1, c))
        pointList.append((r-1, c-1))
        pointList.append((r-1, c+1))
        pointList.append((r, c-1))
        pointList.append((r, c+1))



maxNum = 0
for i in range(n):
    for j in range(m):
        if arr[i][j] > maxNum:
            maxNum = arr[i][j]
print(maxNum)