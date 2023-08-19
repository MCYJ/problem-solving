def KMPSearch(pat, txt):
    M = len(pat)
    N = len(txt)

    lps = [0]*M

    computeLPS(pat, lps)

    i = 0 
    j = 0 
    while i < N:
        if pat[j] == txt[i]:
            i += 1
            j += 1
        elif pat[j] != txt[i]:
            if j != 0:
                j = lps[j-1]
            else:
                i += 1

        # 찾은 경우
        if j == M:
        #    print("Found pattern at index " + str(i-j))
            return True
            j = lps[j-1]
    
    # 없는경우
    return False

def computeLPS(pat, lps):
    leng = 0 
    i = 1
    while i < len(pat):
        if pat[i] == pat[leng]:
            leng += 1
            lps[i] = leng
            i += 1
        else:
            if leng != 0:
                leng = lps[leng-1]
            else:
                lps[i] = 0
                i += 1

# 조금 더 긴 텍스트
# txt = "ABABDABACDABABCABAB"
# pat = "ABABCABAB"
# 본문에서 다룬 예제
track = 'xrviprvipvxrv'
refer = 'vxrvip'

jump_score = 10000
pos = 0

len_track = len(track)

while pos != len_track:
    last_pos = len(track)
    # pos부터 끝까지 슬라이싱
    subtrack = track[pos:last_pos]

    while not KMPSearch(subtrack, refer):
        last_pos -= 1
        subtrack = track[pos:last_pos]
    
    # jump 한 길이만큼 update
    jump_score = min(jump_score, last_pos - pos)

    pos = last_pos

print(jump_score)





