# 24.03.12 21:40 ~ 22:24

def solution(friends, gifts):
    answer = 0
    # 전체 친구의 인원수
    num_of_friends = len(friends)
    # 친구간의 정보 2d-array
    arr_of_friends = [[0 for _ in range(num_of_friends)] for _ in range(num_of_friends)]
    #
    dict_of_friends = {}
    arr_of_gift_index = [0 for _ in range(num_of_friends)]
    arr_of_gift = [0 for _ in range(num_of_friends)]
    for idx, friend in enumerate(friends):
        dict_of_friends[friend] = idx

    for gift in gifts:
        a, b = gift.split(' ')
        arr_of_friends[dict_of_friends[a]][dict_of_friends[b]] += 1
        arr_of_gift_index[dict_of_friends[a]] += 1
        arr_of_gift_index[dict_of_friends[b]] -= 1

    for sendfriend in range(num_of_friends):
        for receivefriend in range(sendfriend, num_of_friends):
            if sendfriend == receivefriend:
                continue

            # 두사람이 선물을 주고 받은 기록이 있다면
            if (arr_of_friends[sendfriend][receivefriend] != 0 or arr_of_friends[receivefriend][sendfriend] != 0) and arr_of_friends[sendfriend][receivefriend] != arr_of_friends[receivefriend][sendfriend]:
                if arr_of_friends[sendfriend][receivefriend] > arr_of_friends[receivefriend][sendfriend]:
                    arr_of_gift[sendfriend] += 1
                else:
                    arr_of_gift[receivefriend] += 1
            # 두사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같음
            else:
                if arr_of_gift_index[sendfriend] == arr_of_gift_index[receivefriend]:
                    continue
                elif arr_of_gift_index[sendfriend] > arr_of_gift_index[receivefriend]:
                    arr_of_gift[sendfriend] += 1
                else:
                    arr_of_gift[receivefriend] += 1

    for idx, item in enumerate(arr_of_gift):
        if answer < item:
            answer = item
    print(answer)
    return answer


friends = ["muzi", "ryan", "frodo", "neo"]
gifts = 	["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]
solution(friends, gifts)