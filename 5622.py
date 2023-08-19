str = input()
tot = 0
lst = [[]]

for i in range(len(str)):
    if ord(str[i]) <= ord('M'):
        tot = tot + 3 + (ord(str[i])%65)//3
    elif ord(str[i]) >= ord('P') and ord(str[i]) <= ord('S'):
        tot = tot + 8
    elif ord(str[i]) >= ord('T') and ord(str[i]) <= ord('V'):
        tot = tot + 9
    else:
        tot = tot + 10

print(tot)