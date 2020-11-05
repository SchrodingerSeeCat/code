n = int(input())
i = 0
j = n * n
while i < j:
    if i + 1 < 10:
        print("0", end="")
    print(i + 1, end="")
    if (i + 1) % n == 0:
        print()
    i += 1
print()
i = 0
num = 1
while i < n:
    j = n - i - 1
    while j > 0:
        print("  ", end="")
        j -= 1
    j = 0
    while j <= i:
        if num < 10:
            print("0", end="")
        print(num, end="")
        num += 1
        j += 1
    print()
    i += 1
