#author madaniel47

n, k = map(int, input().split())

arr = [100001 for i in range(100001)]

arr[n] = 0

q = [n]

while len(q) != 0:
    num = q.pop(0)
    if num < 0 or num > 100000:
        continue

    if num > 0 and arr[num-1] > arr[num]+1:
        arr[num-1] = arr[num]+1
        q.append(num-1)

    if num < 100000 and arr[num+1] > arr[num]+1:
        arr[num+1] = arr[num]+1
        q.append(num+1)

    if num <= 50000 and arr[num*2] > arr[num]:
        arr[num*2] = arr[num]
        q.append(num*2)

print(arr[k])