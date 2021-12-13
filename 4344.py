t = int(input())
plst = []
answer = []
for i in range(t):
    tmp = list(map(int, input().split(' ')))
    p = tmp[0]
    tot = 0
    per = 0
    for j in range(1,len(tmp)):
        tot = tot + tmp[j]
    for k in range(1,len(tmp)):
        if tot/p < tmp[k]:
            per = per+1
    answer.append(per/p*100)
for i in range(t):
    print('{:.3f}%'.format(answer[i]))