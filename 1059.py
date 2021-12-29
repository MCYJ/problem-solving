# madaniel47
# 1059

l = int(input())
sub = list(map(int, input().split()))
n = int(input())

sub.sort()
i = 0
# n의 구간 탐색
while n>sub[i]:
    i = i + 1
if i == 0:
    s = 1
    e = sub[0]-1
else:
    s = sub[i-1]+1
    e = sub[i]-1
# 좋은구간 탐색
if n in sub:
    print('0')
elif s==n:
    print(e-n)
elif n==e:
    print(n-s)
else:
    print((e-n+1)*(n-s)+(e-n))