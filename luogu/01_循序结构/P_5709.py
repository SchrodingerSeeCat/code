import math
m, t, s = map(int, input().split())
num = 0.0
if t == 0:
    print(0)
else:
    num = m - (s / t)
    if num <= 0:
        print(0)
    else:
        print(math.floor(num))