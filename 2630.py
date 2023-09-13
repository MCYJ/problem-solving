# author madaniel47

n = int(input())
arr = []

for i in range(n):
    row = list(map(int, input().split()))
    arr.append(row)

numOfZeroPapers = 0
numOfOnePapers = 0

def dividePaper(r, c, length):
    global numOfZeroPapers, numOfOnePapers

    # 길이가 1칸이면 색깔 return
    if length == 2:
        result = arr[r][c] + arr[r+1][c] + arr[r][c+1] + arr[r+1][c+1]
        if result == 4:
            return 1
        elif result == 0:
            return 0
        else:
            numOfOnePapers += result
            numOfZeroPapers += (4-result)
            return -1

    # 길이가 1칸이 아닌 경우
    # 4칸 쪼개서 recursive
    leftTop = dividePaper(r, c, int(length / 2))
    leftBot = dividePaper(r + int(length / 2), c, int(length / 2))
    rightTop = dividePaper(r, c + int(length / 2), int(length / 2))
    rightBot = dividePaper(r + int(length / 2), c + int(length / 2), int(length / 2))

    if (leftTop == leftBot) and (leftBot == rightTop) and (rightTop == rightBot):
        return leftTop
    else:
        if leftTop == 1:
            numOfOnePapers += 1
        elif leftTop == 0:
            numOfZeroPapers += 1

        if rightTop == 1:
            numOfOnePapers += 1
        elif rightTop == 0:
            numOfZeroPapers += 1

        if leftBot == 1:
            numOfOnePapers += 1
        elif leftBot == 0:
            numOfZeroPapers += 1

        if rightBot == 1:
            numOfOnePapers += 1
        elif rightBot == 0:
            numOfZeroPapers += 1

        return -1

# dividePaper func 실행
master = dividePaper(0, 0, n)

if master == -1:
    print(numOfZeroPapers)
    print(numOfOnePapers)
else:
    if master == 0:
        print(1)
        print(0)
    else:
        print(0)
        print(1)
