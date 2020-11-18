import math
a, b, c = map(float, input().split())
p = (1 / 2) * (a + b + c)
print("%.1f" % (math.sqrt(p * (p - a) * (p - b) * (p - c))))