# 24.03.10 11:30~

bucket = []

# board에는 수정반영 및 없앤 짝 반환
def checkbucket():
    global bucket
    pair = 0
    while len(bucket) >= 2:
        if bucket[-2] == bucket[-1]:
            bucket = bucket[:len(bucket)-2]
            pair += 2
        else:
            return pair
    return pair


def solution(board, moves):
    answer = 0
    # 바구니

    # board의 한쪽변크기
    n = len(board)
    for move in moves:
        move -= 1
        i = 0
        while i < n and board[i][move] == 0:
            i += 1
        if i == n:
            continue
        if board[i][move] != 0:
            bucket.append(board[i][move])
            board[i][move] = 0
        pair = checkbucket()
        answer = answer + pair
    print(answer)
    return answer




board = [[0,0,0,0,0],
         [0,0,1,0,3],
         [0,2,5,0,1],
         [4,2,4,4,2],
         [3,5,1,3,1]]
moves = [1,5,3,5,1,2,1,4]

solution(board, moves)
