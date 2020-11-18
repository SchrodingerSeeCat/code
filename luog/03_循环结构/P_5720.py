import math
length = int(input())
day = 1
while length > 1:
    length = math.floor(length / 2)
    day += 1
print(day)
