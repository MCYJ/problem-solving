def distCal(dist):
    count = 0
    while dist > 1:
        criteria = 2
        while dist > 1:
            dist -= criteria
            count += 1
            criteria += 1
        if dist < 0:
            dist += criteria-1
    return count+dist
    
t = int(input())
dist = []


for i in range(t):
    a,b = map(int, input().split())
    dist.append(b-a)

for i in range(t):
    if dist[i] < 3:
        print(dist[i])
    else:
        print(2+distCal(dist[i]-2))
        

