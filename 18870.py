#author madaniel47
num = int(input())

arr = list(map(int, input().split()))

# 중복 제거 및 sort된 list
new_arr = sorted(set(arr))

new_dict = dict()
j = 0
for i in new_arr:
    new_dict[i] = j
    j += 1

for k in arr:
    print(new_dict[k], end=" ")
