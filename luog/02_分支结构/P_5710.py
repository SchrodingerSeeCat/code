num = int(input())
a, u, b, z = 0, 0, 0, 0
if num % 2 == 0:
    if num > 4 and num <= 12:
        a = 1
    else:
        b = 1
    u = 1
if num % 2 != 0:
    if num > 4 and num <= 12:
        b = 1
        u = 1
    else:
        z = 1
print(a, u, b, z)
