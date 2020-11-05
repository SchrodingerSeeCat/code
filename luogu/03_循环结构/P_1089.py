store = 0
i = 0
sum = 0
month = []
while i < 12:
    month.append(int(input()))
    i += 1
i = 0
while i < 12:
    sum = sum + 300
    sum = sum - month[i]
    if sum < 0:
        print(int(-(i + 1)))
        break
    while sum >= 100:
        store = store + 100
        sum = sum - 100
    i += 1
else:
    print(int(sum + store * 1.2))
