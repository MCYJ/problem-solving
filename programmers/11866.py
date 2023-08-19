def solution(survey, choices):
    types = [0,0,0,0]
    answer = ''
    for i in range(len(survey)):
        
        sur = survey[i]

        # 1~7의 범위를 -3~3의 범위로 만들어줌
        cho = choices[i] - 4

        # 뒷 글자가 사전순으로 더 앞선 경우
        if ord(sur[0]) > ord(sur[1]):
            sur = sur[1]+sur[0]
            cho = -cho
        
        if sur == 'RT':
            types[0] += cho
        elif sur == 'CF':
            types[1] += cho
        elif sur == 'JM':
            types[2] += cho
        else:
            types[3] += cho
    
    if types[0] <= 0:
        answer += 'R'
    else:
        answer += 'T'

    if types[1] <= 0:
        answer += 'C'
    else:
        answer += 'F'

    if types[2] <= 0:
        answer += 'J'
    else:
        answer += 'M'

    if types[3] <= 0:
        answer += 'A'
    else:
        answer += 'N'

    return answer

    

print(solution(["TR", "RT", "TR"], 	[7, 1, 3]))