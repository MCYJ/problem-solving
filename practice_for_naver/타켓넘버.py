from collections import deque

numbers = [4, 1, 2, 1]
target = 4
count = 0
same = 0

def back(numbers, count, total):
    global same
    if count == len(numbers):
        if total == target:
            same += 1
        return
    back(numbers, count+1, total+numbers[count])
    back(numbers, count+1, total-numbers[count])


back(numbers, count, 0)

print(same)