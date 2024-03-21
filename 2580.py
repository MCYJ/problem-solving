# 00:20~
# class 형태 제대로 파악하기
class Sudoku:
    def __init__(self, matrix):
        self.matrix = matrix
        self.zeroList = []
    # 비어있는 칸을 리스트저장하는 메소드
    def makeZeroList(self):
        for i in range(9):
            for j in range(9):
                if self.matrix[i][j] == 0:
                    self.zeroList.append((i, j))

    # 숫자가 들어가도 되는지 판단하는 메소드
    def isNumAvailable(self, r, c, num):
        if self.checkColumn(r, c, num) and self.checkRow(r, c, num) and self.checkBox(r, c, num):
            return True
        else:
            return False

    # 각 위치에 숫자가 와도 되는지 판단하는 메소드
    def checkColumn(self, r, c, num):
        for i in range(9):
            if self.matrix[i][c] == num:
                return False
        return True

    def checkRow(self, r, c, num):
        if num in self.matrix[r]:
            return False
        return True

    def checkBox(self, r, c, num):
        # 어느 사각형에 속한지 계산
        rec_r = int(r/3)*3
        rec_c = int(c/3)*3
        # for loop로 파악
        for i in range(3):
            for j in range(3):
                if self.matrix[rec_r + i][rec_c + j] == num:
                    return False
        return True

    # sudoku board를 채우는 함수
    # fillNum: 내가 넣은 숫자의 갯수
    def fillMatrix(self, fillNum):
        # fillNum를 zerolist갯수와 동일하게 채운경우 matrix를 출력하고 프로그램 종료
        if fillNum == len(self.zeroList):
            self.printMatrix()
            exit()

        # for문을 돌리며 빈칸을 채우기
        for (r, c) in self.zeroList:
            if self.matrix[r][c] != 0:
                continue
            for num in range(1, 10):
                if self.isNumAvailable(r, c, num):
                    self.matrix[r][c] = num
                    self.fillMatrix(fillNum + 1)
                    self.matrix[r][c] = 0
            # 1~9 모든 숫자 다 대입불가능한 경우 return
            if self.matrix[r][c] == 0:
                return

    # matrix 출력 메소드
    def printMatrix(self):
        for i in range(9):
            for j in range(9):
                print(self.matrix[i][j], end=" ")
            print()


matrix = []

for i in range(9):
    line = list(map(int, input().split()))
    matrix.append(line)

sudoku = Sudoku(matrix)
sudoku.makeZeroList()
sudoku.fillMatrix(0)



