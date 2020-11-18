st = input()
if st[0] == "-":
    print("-", end="")
    if st[len(st) - 1] != "0":
        print(st[-1:0:-1])
    else:
        i = len(st) - 1
        while st[i] == "0":
            i -= 1
        print(st[i:0:-1])
else:
    if st[len(st) - 1] != "0":
        print(st[-1::-1])
    else:
        i = len(st) - 1
        while st[i] == "0":
            i -= 1
        print(st[i::-1])
