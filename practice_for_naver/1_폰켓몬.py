# 24.03.11 17:45~17:50

def solution(nums):
    num_only = list(set(nums))

    if len(num_only) < len(nums)/2:
        answer = int(len(num_only))
    else:
        answer = int(len(nums)/2)
    return answer

nums = [3,3,3,2,2,4]
print(solution(nums))
