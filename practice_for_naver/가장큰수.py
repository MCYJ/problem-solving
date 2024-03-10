# 풀이못함
numbers = [6, 10, 2]
strings = list(map(lambda x: str(x), numbers))
strings.sort(reverse=True)
print("".join(strings))