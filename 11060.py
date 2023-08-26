#author madaniel47

n = int(input())
arr = list(map(int, input().split()))

jump = 0

# i: n-1 -> 0
i = n-1
lower = i
while lower != 0:
    i = lower
    

    for j in range(i-1, -1, -1):
        dist = i-j
        if dist <= arr[j]:
            lower = j
    jump = jump + 1
    if i == lower:
        jump = -1
        break

print(jump)
