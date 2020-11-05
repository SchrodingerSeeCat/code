num = list(map(int, input().split()))
i = 0
while i < 2:
    j = 0
    while j < 2 - i:
        if num[j] > num[j + 1]:
            num[j], num[j + 1] = num[j + 1], num[j]
        j += 1
    i += 1
if num[0] + num[1] <= num[2]:
    print("Not triangle")
else:
    if num[0] * num[0] + num[1] * num[1] == num[2] * num[2]:
        print("Right triangle")
    if num[0] * num[0] + num[1] * num[1] > num[2] * num[2]:
        print("Acute triangle")
    if num[0] * num[0] + num[1] * num[1] < num[2] * num[2]:
        print("Obtuse triangle")
    if num[0] == num[1]:
        print("Isosceles triangle")
    if num[1] == num[2]:
        print("Equilateral triangle")