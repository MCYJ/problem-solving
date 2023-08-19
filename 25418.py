#author madaniel47
a, k = map(int, input().split())

arr = [1000000] * 1000001

for i in range(a, k+1):
    arr[i] = i-a

arr[a] = 0

# def findResult(num):
#     if num > k:
#         return
#     elif num < 0:
#         return
#     elif arr[num-1]+1 >= arr[num] and (arr[int(num/2)]+1 >= arr[num] if num%2 == 0 else (1)):
#         return
#     else:
#         arr[num] = min(arr[num-1]+1, arr[num])
#         if num%2 == 0:
#             arr[num] = min(arr[int(num/2)]+1, arr[num])
#         findResult(num+1)
#         findResult(num*2)

# findResult(a+1)
# findResult(a*2)

for num in range(a, k+1):
    if num+1 > k:
        pass
    else:
        arr[num+1] = min(arr[num+1], arr[num]+1)
        
    if num*2 > k:
        pass
    else:
        arr[num*2] = min(arr[num*2], arr[num]+1)

print(arr[k])