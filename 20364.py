earth, duck = map(int, input().split(' '))
wantList = []
earthList = [0]*(earth+1)

for i in range(duck):
    wantList.append(int(input()))

for no in wantList:
    meetNo = 0
    # 맨처음 no 처리
    if earthList[no] == 1:
        meetNo == no
    else:
        earthList[no] = 1
    
    while no != 1: 
        if no%2 == 1:
            no = int((no-1)/2)
        else:
            no = int(no/2)
        if earthList[no] == 1:
            meetNo = no
    print(meetNo) 