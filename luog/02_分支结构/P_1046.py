apples = list(map(int, input().split()))
height = int(input()) + 30
sum = 0
for apple in apples:
    if apple <= height:
        sum += 1
print(sum)