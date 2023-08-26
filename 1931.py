# author madaniel47

n = int(input())

arr = []

for i in range(n):
    arr.append(list(map(int, input().split())))

arr = sorted(arr, key=lambda x: (x[1], x[0]))

i = 1
count = 1
pos = 0
visited = [0 for i in range(n)]
visited[0] = 1
while i < n:
    if arr[pos][1] <= arr[i][0]:
        if visited[i] == 0:
            count = count + 1
            pos = i
            visited[i] = 1
        
    i = i + 1

print(count)