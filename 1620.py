#author madaniel47

n, m = map(int, input().split())

n_list = []
n_dict = dict()
m_list = []
answer_list = []

for i in range(n):
    str_n = input()
    n_list.append(str_n)
    n_dict[str_n] = i
for _ in range(m):
    m_list.append(input())

for i in range(m):
    if m_list[i] in n_dict:
        answer_list.append(n_dict[m_list[i]]+1)
    else:
        answer_list.append(n_list[int(m_list[i])-1])

for i in range(m):
    print(answer_list[i])
