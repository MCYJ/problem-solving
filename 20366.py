n = int(input())
snowList = list(map(int, input().split()))
snowList.append(0)

snowList.sort()

if n%2 == 0:
    print(snowList[n//2]+snowList[n//2+2]-snowList[n//2+1]-snowList[n//2-1])
else:
    # 3,5 / 4,6
    t1 = snowList[n//2+1] + snowList[n//2+3] - snowList[n//2] - snowList[n//2+2]
    # 2,4 / 3,5
    t2 = snowList[n//2] + snowList[n//2+2] - snowList[n//2-1] - snowList[n//2+1]
    print(t1) if t1 < t2 else print(t2)