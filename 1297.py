import math

d, h, w = map(int, input().split())

ratio = math.sqrt((d**2)/(h**2+w**2))

print(int(ratio*h), int(ratio*w))