# boj 1065
# madaniel47

def isThisHansu(n):
    if n < 100:
        return True
    elif n == 1000:
        return False
    else:
        if n//100 - (n//10)%10 == (n//10)%10 - n%10:
            return True



n = int(input())
tot = 0

for i in range(1,n+1):
    if isThisHansu(i):
        tot = tot + 1

print(tot)