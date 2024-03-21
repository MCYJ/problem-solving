# 14:41~14:26
class Shortcut:
    def __init__(self, num_of_words):
        self.list_of_keys = []
        self.list_of_shortcuts = []
        self.num_of_words = num_of_words

    # 리스트형태의 shortcut을 삽입
    def addShortcut(self, line_shortcut):
        self.list_of_shortcuts.append(list(line_shortcut.split()))

    def makeShortcut(self):
        for idx_outer, line_shortcut in enumerate(self.list_of_shortcuts):
            _find = False
            for idx_inner, option in enumerate(line_shortcut):
                if option[0] not in self.list_of_keys:
                    self.list_of_keys.append(option[0])
                    self.list_of_keys.append(option[0].swapcase())
                    # [] 형태로 교체
                    self.list_of_shortcuts[idx_outer][idx_inner] = self.list_of_shortcuts[idx_outer][idx_inner].replace(
                        option[0], "[" + option[0] + "]", 1)
                    _find = True
                    break
            if _find == True:
                continue
            find = False
            # dict에 모든 앞글자가 다 있는 경우
            for idx_inner, option in enumerate(line_shortcut):
                if find == True:
                    break
                for idx in range(len(option)):
                    if option[idx] == '[' or option[idx] == ']':
                        continue
                    if option[idx] not in self.list_of_keys:
                        self.list_of_keys.append(option[idx])
                        self.list_of_keys.append(option[idx].swapcase())
                        # dict에 없으면 각 위치를 지정
                        self.list_of_shortcuts[idx_outer][idx_inner] = self.list_of_shortcuts[idx_outer][
                            idx_inner].replace(option[idx], "[" + option[idx] + "]", 1)
                        find = True
                        break

    # shortcuts을 출력
    def printShortcut(self):
        for shortcuts in self.list_of_shortcuts:
            for option in shortcuts:
                print(option, end=" ")
            print()


n = int(input())
shortcut = Shortcut(n)

for _ in range(n):
    # 갯수만큼 list에 추가
    line_shortcut = input()
    shortcut.addShortcut(line_shortcut)

shortcut.makeShortcut()
shortcut.printShortcut()

