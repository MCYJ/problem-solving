n = int(input())
str = input()
count = 0
if str[0] == str[1]:
    for i in range(len(str)-1):
        if str[i] != str[i+1]:
            count = count + 1
    print(2) if count <= 2 else print(count-1)
else:
    for i in range(len(str)-2):
        if str[i] != str[i+1]:
            count = count + 1
    print(3) if count <= 2 else print(count)