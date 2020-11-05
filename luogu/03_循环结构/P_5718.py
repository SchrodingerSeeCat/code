n = int(input())
num_list = list(map(int, input().split()))
min = num_list[0]
for num in num_list:
    if min > num:
        min = num
print(min)
