n = float(input())
key = 2.0
count = 0
sum = 0
while sum < n:
    sum = sum + key
    key = key * 0.98
    count += 1
print(count)
