n, k = map(int, input().split())
lst = []
cnt = 0
for i in range(1, n+1):
    lst.append([i,0])

# n개의 출력이 발생될때까지 반복
i = 0
j = 0
while i < n:
    # if lst[][1] == 0 일때만 k-1 번 인덱스 올리기
    r = 0
    while r < k-1:   
        if lst[j][1] == 0:
            r = r + 1
        j = j + 1 if j < n-1 else 0

    print(lst[j%n][0], end=" ")
    lst[j][1] = 1

    j = j + 1 if j < n-1 else 0
    i = i + 1