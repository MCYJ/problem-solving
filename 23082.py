#author madaniel47
n = int(input())
result = []
if n == 0:
	print(n)
else:
	while n != 0:
		if n%3 == 2:
			result.append('T')
			n = n//3 + 1
		else:
			result.append(n%3)
			n = n//3

	for i in range(len(result)):
		print(result[len(result)-i-1], end="")