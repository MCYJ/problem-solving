#author madaniel47
n, m = map(int, input().split())

n_list = [""] * n
m_list = [""] * m

result = 0
result_arr = []

for i in range(n):
    n_list[i] = input()

for i in range(m):
    m_list[i] = input()

n_list.sort()
m_list.sort()

x = 0
y = 0

while x != n and y != m:
    if n_list[x] == m_list[y]:
        result += 1
        result_arr.append(n_list[x])
        x += 1
        y += 1
    elif n_list[x] > m_list[y]:
        y += 1
    elif n_list[x] < m_list[y]:
        x += 1

print(result)
for stri in result_arr:
    print(stri)

