# 24.03.12 22:24 ~ 23:43

from collections import deque
def solution(edges):
    answer = [0, 0, 0, 0]
    set_node = set()
    dict_node_num = {}
    for edge in edges:
        set_node.add(edge[0])
        set_node.add(edge[1])

    for idx, node in enumerate(set_node):
        dict_node_num[node] = idx

    total_nodes = len(set_node)

    arr_edges = [[] for _ in range(total_nodes)]
    # 0: out / 1: in
    arr_degree = [[0, 0] for _ in range(total_nodes)]

    for edge in edges:
        go = edge[0]
        to = edge[1]

        arr_degree[dict_node_num[go]][0] += 1
        arr_degree[dict_node_num[to]][1] += 1

        # 시작노드 기준으로 하나씩 리스트로 추가함
        arr_edges[dict_node_num[go]].append(dict_node_num[to])

    for idx, node in enumerate(arr_degree):
        # 순수 outdegree가 2이상인 경우 > startnode
        if node[0] - node[1] > 1:
            for key, value in dict_node_num.items():
                if idx == value:
                    answer[0] = key



    for node in arr_edges[dict_node_num[answer[0]]]:
        arr_degree[node][1] -= 1

    for node in arr_degree:
        if node[0] == 2 and node[1] == 2:
            answer[3] += 1
        elif (node[0] == 1 and node[1] == 0) or (node[0] == 0 and node[1] == 1):
            answer[2] += 1
        elif (node[0] == 0 and node[1] == 0):
            answer[2] += 2

    answer[2] = int(answer[2]/2)
    answer[1] = len(arr_edges[dict_node_num[answer[0]]]) - answer[2] - answer[3]

    return answer

edges = [[2, 3], [4, 3], [1, 1], [2, 1]]


solution(edges)