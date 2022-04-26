numberLine = list(map(int, input().split()))

tot = 0

for no in numberLine:
    tot += no**2

print(tot%10)