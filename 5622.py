str = input()
tot = 0
lst = [[]]

for i in range(len(str)):
    if str[i] <= ord('M'):
        tot = tot + 3 + (ord(str[i])%65)//3
    elif str[i] >= ord('P') and str[i] <= ord('S'):
        tot = tot + 8
    elif str[i] >= ord('T') and str[i] <= ord('V'):
        tot = tot + 9
    else:
        tot = tot + 10

print(tot)