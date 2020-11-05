n = int(input())
i = n;
digit = 1
while i > 0:
    j = 0
    while j < i:
        if digit < 10:
            print("0%d" % digit, end="")
        else:
            print(digit, end="")
        digit += 1
        j += 1
    print()
    i -= 1