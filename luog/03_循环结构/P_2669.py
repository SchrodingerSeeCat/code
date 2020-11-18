K = int(input())
i = 1
money = 0
gold = 1
while i <= K:
    j = 0
    while True:
        money += gold
        j += 1
        i += 1
        if i > K:
            break
        if j >= gold:
            gold += 1
            break
print(money)
