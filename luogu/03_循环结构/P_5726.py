n = int(input())
num_list = list(map(int, input().split()))
print("%.2f" % ((sum(num_list) - max(num_list) - min(num_list))/(n - 2)))
