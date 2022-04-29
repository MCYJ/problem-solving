a,b,c,d = map(int, input().split())
p,m,n = map(int, input().split())

tot = 0

temp = p%(a+b)
if temp != 0 and temp <=a:
    tot += 1

temp = p%(c+d)
if temp != 0 and temp <=c:
    tot += 1
print(tot)
tot = 0
temp = m%(a+b)
if temp != 0 and temp <=a:
    tot += 1

temp = m%(c+d)
if temp != 0 and temp <=c:
    tot += 1
print(tot)
tot = 0
temp = n%(a+b)
if temp != 0 and temp <=a:
    tot += 1

temp = n%(c+d)
if temp != 0 and temp <=c:
    tot += 1
print(tot)