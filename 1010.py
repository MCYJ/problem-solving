t = int(input())
tot = []

for i in range(t):
	tot.append(list(map(int, input().split(' '))))

for i in range(t):
	le = tot[i][0]
	ri = tot[i][1]
	tempSon = 1
	tempPra = 1
	for _ in range(le):
		tempSon *= ri
		ri -= 1
	while le>=1:
		tempPra *= le
		le -= 1
	print(int(tempSon/tempPra))