#author madaniel47

r, c = map(int, input().split())

arr = [[0 for i in range(c)] for j in range(r)]

total_wolf = 0
total_sheep = 0

for i in range(r):
    row = input()
    for j in range(c):
        # 빈공간
        if row[j] == '.':
            arr[i][j] = 0
        # 울타리
        elif row[j] == '#':
            arr[i][j] = -1
        # 양
        elif row[j] == 'o':
            arr[i][j] = 1
        # 늑대
        else:
            arr[i][j] = 2

for i in range(r):
    for j in range(c):
        if arr[i][j] != -1:
            wolf = 0
            sheep = 0
            path = [(i, j)]

            while len(path) != 0:
                k, h = path.pop(0)
                if k < 0 or k >= r or h < 0 or h >= c:
                    continue
                if arr[k][h] == -1:
                    continue
                if arr[k][h] == 1:
                    sheep = sheep + 1
                if arr[k][h] == 2:
                    wolf = wolf + 1
                arr[k][h] = -1
                path.append((k+1, h))
                path.append((k-1, h))
                path.append((k, h+1))
                path.append((k, h-1))
            if wolf >= sheep:
                total_wolf = total_wolf + wolf
            else:
                total_sheep = total_sheep + sheep

print(total_sheep, total_wolf)

