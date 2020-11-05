import math
a, b = map(int, input().split())
while a <= b:
    sqrt_a = math.sqrt(a)
    i = 2
    while i <= sqrt_a:
        if a % i == 0:
            break
        i += 1
    if i > sqrt_a:
        str_a = str(a)
        if str_a == str_a[-1::-1]:
            print(a)
    a += 1
