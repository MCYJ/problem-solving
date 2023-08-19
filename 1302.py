n = int(input())
arr = []

for _ in range(n):
    arr.append(input())

result = {}

for i in range(n):
    if arr[i] in result:
        result[arr[i]] += 1
    else:
        result[arr[i]] = 1
top = 0
keys = result.keys()
most = []
for name in keys:
    if top < result[name]:
        top = result[name]
        most = [name]
    elif top == result[name]:
        most.append(name)
most.sort()

print(most[0])
