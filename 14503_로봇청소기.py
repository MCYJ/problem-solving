# 24.03.13 17:30 ~ 18:05 19:15 ~ 19:35
import copy
class RobotCleaner:
    cleanarea = 0
    moving = [[1, 0],[0, -1],[-1, 0],[0, 1]]
    def __init__(self, r, c, d, n, m, roomInfo):
        self.r = r
        self.c = c
        self.d = d
        self.n = n
        self.m = m
        self.roomInfo = copy.deepcopy(roomInfo)
        # self.trashInfo = [[0 for _ in range(m)] for _ in range(n)]
        self.trashInfo = copy.deepcopy(roomInfo)
    # 청소되지 않은 구역이 주변에 있는지 check
    def checkTrash(self):
        if self.trashInfo[self.r][self.c] == 0:
            self.trashInfo[self.r][self.c] = 1
            self.cleanarea += 1

        for move_r, move_c in self.moving:
            if (0 <= self.r + move_r < self.n) and (0 <= self.c + move_c < self.m):
                # 청소가능구역이 존재하는 경우
                if self.trashInfo[self.r+move_r][self.c+move_c] == 0:
                    return True
        # 청소가능구역이 존재하지 않는 경우
        return False

    def moveBack(self):
        if self.d == 0:
            move_r, move_c = self.moving[0]
        elif self.d == 1:
            move_r, move_c = self.moving[1]
        elif self.d == 2:
            move_r, move_c = self.moving[2]
        else:
            move_r, move_c = self.moving[3]

        if (0 <= self.r + move_r < self.n) and (0 <= self.c + move_c < self.m) and self.roomInfo[self.r + move_r][self.c + move_c] == 0:
            self.r += move_r
            self.c += move_c
            return True
        else:
            return False

    def checkFront(self):
        move_r, move_c = self.moving[self.d]
        if (0 <= self.r + move_r < self.n) and (0 <= self.c + move_c < self.m) and (self.trashInfo[self.r - move_r][self.c - move_c] == 0) and (self.roomInfo[self.r - move_r][self.c - move_c] == 0):
            self.r -= move_r
            self.c -= move_c
            return True
        else:
            return False
    # 청소한 곳 return
    def clean(self):
        while True:
            # 주변의 쓰레기청소가 가능한 곳 확인
            while self.checkTrash():
                # 방향변경
                self.d = (self.d - 1 + 4) % 4
                # 청소 안했으면 한칸 전진, 아니면 계속 돌기
                if self.checkFront():
                    pass
            # 바라보는 방향에서 뒤로 한칸 후진
            if self.moveBack():
                pass
            else:
                return self.cleanarea

# 방의 크기 N / M
N, M = map(int, input().split())
# 청소기의 위치 R C / 청소기의 방향 D
R, C, D = map(int, input().split())
RoomInfo = [0 for _ in range(N)]
# 방의 정보
for idx in range(N):
    RoomInfo[idx] = list(map(int, input().split()))

robotcleaner = RobotCleaner(R, C, D, N, M, RoomInfo)
print(robotcleaner.clean())

