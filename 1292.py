a, b = map(int, input().split())
tot = [0]*(b+1)
base = 1
for i in range(1, b+1):
    j = 0
    while j<base and i+j<=b:
        tot[i+j] = base
        j += 1
    i = i+j
    base += 1