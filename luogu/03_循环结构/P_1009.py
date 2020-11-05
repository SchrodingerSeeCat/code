def factorial(num):
    sum = 1
    i = 1
    while i <= num:
        sum = sum * i
        i += 1
    return sum


n = int(input())
i = 1
sum = 0
while i <= n:
    sum = sum + factorial(i)
    i += 1
print(sum)