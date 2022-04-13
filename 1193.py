x = int(input())
i = 1
while x-i > 0:
    x -= i
    i += 1 

if i%2 == 0:
    print(x,'/',i+1-x, sep='')
else:
    print(i+1-x,'/',x, sep='')
