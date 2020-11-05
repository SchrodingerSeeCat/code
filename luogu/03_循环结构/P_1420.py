n = int(input())
num = list(map(int, input().split()))
i = 1
count = 1
max_count = 1
while i < n:
    if num[i] == num[i - 1] + 1:
        count += 1
    else:
        if count > max_count:
            max_count = count
        count = 1
    i += 1
print(max_count)
