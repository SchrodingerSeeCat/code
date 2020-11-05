import math
n = int(input())
n_sqrt = math.floor(math.sqrt(n))
i = n_sqrt
while i > 0:
    if n % i == 0:
        print(n // i)
        break
    i -= 1
