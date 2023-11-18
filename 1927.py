#author madaniel47

operation = int(input())

arr = []

for i in range(operation):
    num = int(input())

    if num == 0:
        if len(arr) == 0:
            print(0)
        else:
            print(arr.pop(0))
    else:
        if len(arr) == 0:
            arr.append(num)
        else:
            for i in range(len(arr)):
                if num <= arr[i]:
                    arr.insert(i, num)
                    break
            
            if num > arr[-1]:
                arr.append(num)
        