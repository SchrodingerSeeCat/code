def find_str(char):
    if char == "A":
        return 0
    if char == "B":
        return 1
    return 2


num = list(map(int, input().split()))
str = input().strip()
i = 0
while i < 2:
    j = 0
    while j < 2 - i:
        if num[j] > num[j + 1]:
            num[j], num[j + 1] = num[j + 1], num[j]
        j += 1
    i += 1
for v in str:
    print(num[find_str(v)], end=" ")
