import math
n = int(input())
i = 2
sum = 0
count = 0
while True:
    j = 2
    while j < math.sqrt(i):
        if i % j == 0:
            break
        j += 1
    if j > math.sqrt(i):
        sum += i
        if sum > n:
            print(count)
            break
        count += 1
        print(i)
    i += 1
