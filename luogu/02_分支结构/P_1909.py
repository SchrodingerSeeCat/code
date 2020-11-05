import math
num = int(input())
money = 0
i = 0
while i < 3:
    pen, price = map(int, input().split())
    if i == 0:
        money = math.ceil(num / pen) * price
    else:
        if money > math.ceil(num / pen) * price:
            money = math.ceil(num / pen) * price
    i += 1
print(money)