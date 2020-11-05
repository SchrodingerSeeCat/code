a, b, c = map(int, input().split())
array = [a, b, c]
i = 0
while i < 2:
    j = 0
    while j < 2 - i:
        if array[j] > array[j + 1]:
            temp = array[j]
            array[j] = array[j + 1]
            array[j + 1] = temp
        j += 1
    i += 1
for n in array:
    print(n, end=" ")