from collections import deque



def solution(maps):
    # 상하좌우 움직임
    moving = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    visited = [[0 for i in range(len(maps[0]))] for j in range(len(maps))]

    answer = 0

    steps = 0
    queue = list()
    queue.append(-1)
    queue.append([0, 0])

    while len(queue):
        q = queue.pop(0)

        # 중간 -1을 만났을 경우
        if q == -1:
            steps += 1
            queue.append(-1)
            q = queue.pop(0)
            if q == -1:
                return -1

        r = q[0]
        c = q[1]

        # map을 벗어나는 경우
        if r < 0 or r >= len(maps) or c < 0 or c >= len(maps[0]):
            continue

        # 벽을 만났을 경우
        if maps[r][c] == 0:
            continue

        # 이미 방문한 경우
        if visited[r][c] == 1:
            continue
        else:
            visited[r][c] = 1

        # 목적지에 도달했을 경우
        if r == len(maps)-1 and c == len(maps[0])-1:
            answer = steps
            return answer

        # 다음 칸 진행
        for move in moving:
            queue.append([r + move[0], c + move[1]])

    return -1

solution([[1,0,1,1,1],
          [1,0,1,0,1],
          [1,0,1,1,1],
          [1,1,1,0,1],
          [0,0,0,0,1]])