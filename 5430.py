#author madaniel47

testcase = int(input())

arr_funcs = []
arr_cases = []
arr_nums = []
arr_results = []
arr_poss = []

for _ in range(testcase):
    arr_funcs.append(input())
    arr_cases.append(int(input()))
    arr_nums.append(input().split('[')[1].split(']')[0].split(','))

for i in range(testcase):
    arr_func = arr_funcs[i]
    arr_case = arr_cases[i]
    arr_num = arr_nums[i]

    # 1 정방향 -1 역방향
    pos = 1


    for j in range(len(arr_func)):
        word = arr_func[j]

        if word == 'D':
            if len(arr_num) <= 0 or arr_num[0] == '':
                arr_num = -1
                break
            if pos == 1:
                arr_num.pop(0)
            else:
                arr_num.pop(len(arr_num)-1)

        if word == 'R':
            pos = pos * -1

    arr_poss.append(pos)
    arr_results.append(arr_num)

for i in range(testcase):
    result = arr_results[i]
    pos = arr_poss[i]
    if result == -1:
        print('error')
        continue
    if len(result) == 0:
        print('[]')
        continue

    print('[', end="")
    # 정방향
    if pos == 1:
        for j in range(len(result)-1):
            if result[j] == 0:
                continue
            print(result[j], end=",")
        print(result[len(result)-1], end="")
    # 역방향
    else:
        for j in range(len(result)-1, 0, -1):
            if result[j] == 0:
                continue
            print(result[j], end=",")
        print(result[0], end="")
    print(']')