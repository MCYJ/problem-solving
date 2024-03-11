# 24.03.11 23:50~
def solution(clothes):
    answer = 1

    types_of_clothes = dict()
    for cloth in clothes:
        if cloth[1] in types_of_clothes:
            types_of_clothes[cloth[1]] += 1
        else:
            types_of_clothes[cloth[1]] = 1
    for item in types_of_clothes.values():
        answer *= (item+1)

    answer -= 1

    return answer


clothes = [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]
print(solution(clothes))