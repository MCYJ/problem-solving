#author madaniel47
import math

n = int(input())
if n == 0:
    print(0)
    exit()
arr =[]

for i in range(n):
    arr.append(int(input()))

arr.sort()
tot = 0
exc = int(math.floor(n * 0.15 + 0.5))
for i in range(exc, n-exc):
    tot = tot + arr[i]

result = int(math.floor(tot / (n - exc*2) + 0.5))

print(result)