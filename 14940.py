#author madaniel47

n, m = map(int, input().split())

arr = [0]*n

for i in range(n):
    arr[i] = list(map(int, input().split()))

visited = [[0 for i in range(m)] for j in range(n)]
pointed = [[0 for i in range(m)] for j in range(n)]

target_point_x = 0
target_point_y = 0

for i in range(n):
    for j in range(m):
        if arr[i][j] == 2:
            target_point_x = j
            target_point_y = i
            break

point= 0
stack_x = []
stack_y = []

stack_x.append(target_point_x)
stack_y.append(target_point_y)
stack_x.append('s')
stack_y.append('s')

while len(stack_x) != 0:
    x = stack_x.pop(0)
    y = stack_y.pop(0)

    if x == 's':
        point = point + 1
        if len(stack_x) == 0:
            break
        stack_x.append('s')
        stack_y.append('s')
        continue
    if x < 0 or x >= m or y < 0 or y >= n:
        continue
    if visited[y][x] == 1 or arr[y][x] == 0:
        continue
    
    # 방문기록
    visited[y][x] = 1

    pointed[y][x] = point

    stack_x.append(x+1)
    stack_y.append(y)
    stack_x.append(x-1)
    stack_y.append(y)
    stack_x.append(x)
    stack_y.append(y+1)
    stack_x.append(x)
    stack_y.append(y-1)

for i in range(n):
    for j in range(m):
        if visited[i][j] == 0 and arr[i][j] == 1:
            pointed[i][j] = -1

for i in range(n):
    for j in range(m):
        print(pointed[i][j], end=" ")
    print()